package com.inspur.gift.controller;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspur.gift.bean.GiftBody;
import com.inspur.gift.model.Gift;
import com.inspur.gift.service.GiftService;
import com.inspur.gift.servlet.UploadHandler;
import com.inspur.gift.util.Files;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.PageBean;
import com.inspur.gift.util.Params;
import com.inspur.gift.util.ResultCode;
import com.inspur.gift.util.Results;
import com.inspur.gift.util.exception.GiftBusinessException;
import com.inspur.gift.util.tool.PathUtil;
import com.inspur.gift.util.tool.PropertiesIOUtil;
import com.inspur.gift.util.tool.TimeUtils;

@Controller
@RequestMapping("/gift/gift")
public class GiftController {

	/**
	 * 日志操作
	 */
	private static final Log LOGGER = LogFactory.getLog(GiftController.class);

	@Autowired
	private GiftService giftService;

	@ResponseBody
	@RequestMapping(value = "/action/add.do", method = RequestMethod.POST)
	public OperationResult add(HttpServletRequest request,
			@RequestParam(value = "chunk", required = true) int chunk,
    		@RequestParam(value = "chunkSize") long chunkSize,
    		@RequestParam(value = "imgName") String imgName,  		
    		@RequestParam(value = "size") long size,
    		@RequestParam(value = "count") String count,
    		@RequestParam(value = "isFinished") boolean isFinished,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "description", required = true) String description,
			@RequestParam(value = "places", required = true) String places){
		try {
			String relativePath = PropertiesIOUtil.getValue("path");
			String rootPath = PathUtil.getInstance().getRootPath();
			String[] WPlaces = StringUtils.split(places);
			if (Params.isNull(rootPath, relativePath, imgName, name, places, WPlaces)) {
				return Results.oprResult(false, ResultCode.ERROR_GIFT_PATH_ERROR.toString(), null);
			}

			imgName = new String(imgName.getBytes("ISO-8859-1"), "UTF-8");
			String path = Files.toPath(rootPath, relativePath);
			path = Files.formatPath(path);
			String imgPath = Files.toFile(path, imgName);
        	File file  = new File(imgPath);
        	InputStream inputStream = request.getInputStream();
        	UploadHandler.uploadFile(inputStream, file, chunk, chunkSize);
        	if (isFinished) {
        		Gift gift = new Gift();
        		gift.setName(name);
        		gift.setDescription(description);
        		gift.setCreaterId("");
        		gift.setImgUrl(imgPath);
        		Date date = TimeUtils.getInstance().getDate();
        		gift.setCreateTime(date);
        		gift.setUpdateTime(date);
        		gift.setFlag("1");
        		giftService.addGift(gift, WPlaces);
        	}
        	return null;
		} catch (GiftBusinessException e){
			LOGGER.error("添加礼物操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_ADD_WORKPLACE.toString(), null);
		} catch (Exception e) {
			LOGGER.error("添加礼物操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/action/delete.do", method = RequestMethod.POST)
	public OperationResult delete(HttpServletRequest request,
			@RequestBody GiftBody giftList){
		try {
			List<String> ids = giftList.getIds();
			if (Params.isBlankCollection(ids)) {
				return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
			}
			OperationResult result = giftService.delete(ids);
			return Results.oprResult(result);
		} catch (GiftBusinessException e){
			LOGGER.error("删除礼物操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_DELETE_GIFT.toString(), null);
		} catch (Exception e) {
			LOGGER.error("删除礼物操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/action/modify.do", method = RequestMethod.POST)
	public OperationResult modify(HttpServletRequest request,
			@RequestBody GiftBody giftList,
			@RequestParam(value = "places", required = true) String places){
		try {
			Gift newGift = giftList.getNewObj();
			Gift oldGift = giftList.getOldObj();
			String[] WPlaces = StringUtils.split(places);
			if (Params.isNull(newGift, oldGift, places, WPlaces)) {
				return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
			}
			OperationResult result = giftService.modify(newGift, oldGift, WPlaces);
			return result;
		} catch (GiftBusinessException e){
			LOGGER.error("修改礼物操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_MODIFY_BUME.toString(), null);
		} catch (Exception e) {
			LOGGER.error("修改礼物操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/action/search.do", method = RequestMethod.POST)
	@SuppressWarnings("rawtypes")
	public OperationResult search(HttpServletRequest request,
//			@RequestBody GiftBody giftBody
			@RequestParam(value = "searchType") String searchType,
			@RequestParam(value = "placeId") String placeId,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
			@RequestParam(value = "dir", defaultValue = "asc") String dir,
			@RequestParam(value = "field", defaultValue = "name") String field
			){
		OperationResult result = null;
		try {
//			String searchType = giftBody.getSearchType();
			if (Params.isNull(page, pageSize, field)) {
				return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
			}

			if (!Params.isSorted(dir)) {
				return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
			}

			PageBean pageBean = new PageBean(page, pageSize, dir, field);
			switch (searchType) {
			case "0":
				result = giftService.search(pageBean);
				break;
			case "1":
//				String placeId = giftBody.getPlaceId();
				if (Params.isNull(placeId)) {
					return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
				}
				result = giftService.search(placeId, pageBean);
				break;
			case "2":
//				String uuid = giftBody.getPlaceId();
				if (Params.isNull(placeId)) {
					return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
				}
				result = giftService.search(placeId);
			}
			
			return result;
		} catch (GiftBusinessException e){
			LOGGER.error("查看礼物操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_SEARCH_BUME.toString(), null);
		} catch (Exception e) {
			LOGGER.error("查看礼物操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}
}
