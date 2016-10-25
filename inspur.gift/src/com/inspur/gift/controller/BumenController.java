package com.inspur.gift.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspur.gift.bean.BumenBody;
import com.inspur.gift.model.Bumen;
import com.inspur.gift.service.BumenService;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.Params;
import com.inspur.gift.util.ResultCode;
import com.inspur.gift.util.Results;
import com.inspur.gift.util.exception.GiftBusinessException;
import com.inspur.gift.util.tool.TimeUtils;

/**
 * 部门增、删、改、查rest接口操作
 * @author gzc
 *
 */
@Controller
@RequestMapping("/gift/bumen")
public class BumenController {

	/**
	 * 日志记录
	 */
	private static final Log LOGGER = LogFactory.getLog(BumenController.class);

	@Autowired
	private BumenService bumenService;

	@ResponseBody
	@RequestMapping(value = "/action/add.do", method = RequestMethod.POST)
	public OperationResult add(HttpServletRequest request,
			@RequestParam(value = "name", required = true) String name){
		OperationResult result = new OperationResult();
		try {
			if (Params.isNull(name)) {
				return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
			}
			Bumen bumen = new Bumen();
			bumen.setName(name);
			Date date = TimeUtils.getInstance().getDate();
			bumen.setCreateTime(date);
			bumen.setUpdateTime(date);
			bumen.setFlag("1");
			result = bumenService.addBumen(bumen);
			return Results.oprResult(result);
		} catch (GiftBusinessException e){
			LOGGER.error("添加部门操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_ADD_BUMEN.toString(), null);
		} catch (Exception e) {
			LOGGER.error("添加部门操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/action/delete.do", method = RequestMethod.POST)
	public OperationResult delete(HttpServletRequest request,
			@RequestBody BumenBody bumenList){
		try {
			List<String> ids = bumenList.getIds();
			if (!Params.isBlankCollection(ids)) {
				OperationResult result = bumenService.delete(ids);
				return Results.oprResult(result);
			} else {
				return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
			}
		} catch (GiftBusinessException e){
			LOGGER.error("删除部门操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_DELETE_BUME.toString(), null);
		} catch (Exception e) {
			LOGGER.error("删除部门操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/action/modify.do", method = RequestMethod.POST)
	public OperationResult modify(HttpServletRequest request,
			@RequestBody BumenBody bumenList){
		try {
			Bumen newBumen = bumenList.getNewObj();
			Bumen oldBumen = bumenList.getOldObj();
			if (Params.isNull(newBumen, oldBumen)) {
				return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
			}
			OperationResult result = bumenService.modify(newBumen, oldBumen);
			return result;
		} catch (GiftBusinessException e){
			LOGGER.error("修改部门操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_MODIFY_BUME.toString(), null);
		} catch (Exception e) {
			LOGGER.error("修改部门操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/action/search.do", method = RequestMethod.POST)
	public OperationResult search(HttpServletRequest request){
		OperationResult result = new OperationResult();
		try {
			result = bumenService.search();
			return Results.oprResult(result);
		} catch (GiftBusinessException e){
			LOGGER.error("添加部门操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_SEARCH_BUME.toString(), null);
		} catch (Exception e) {
			LOGGER.error("添加部门操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}
}
