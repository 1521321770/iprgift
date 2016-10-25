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

import com.inspur.gift.bean.WorkplaceBody;
import com.inspur.gift.model.Workplace;
import com.inspur.gift.service.WorkplaceService;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.Params;
import com.inspur.gift.util.ResultCode;
import com.inspur.gift.util.Results;
import com.inspur.gift.util.exception.GiftBusinessException;

/**
 * 工作地增、删、改、查rest接口操作
 * @author gzc
 *
 */
@Controller
@RequestMapping("/gift/workplace")
public class WorkplaceController {

	/**
	 * 日志操作
	 */
	private static final Log LOGGER = LogFactory.getLog(WorkplaceController.class);

	@Autowired
	private WorkplaceService workplaceService;

	@ResponseBody
	@RequestMapping(value = "/action/add.do", method = RequestMethod.POST)
	public OperationResult add(HttpServletRequest request,
			@RequestParam(value = "name", required = true) String name){
		try {
			if (Params.isNull(name)) {
				return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
			}
			Workplace wPlace = new Workplace();
			wPlace.setName(name);
			Date date = new Date();
			wPlace.setCreateTime(date);
			wPlace.setUpdateTime(date);
			wPlace.setFlag("1");
			OperationResult result = workplaceService.addWorkplace(wPlace);
			return result;
		} catch (GiftBusinessException e){
			LOGGER.error("添加工作地操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_ADD_WORKPLACE.toString(), null);
		} catch (Exception e) {
			LOGGER.error("添加工作地操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/action/delete.do", method = RequestMethod.POST)
	public OperationResult delete(HttpServletRequest request,
			@RequestBody WorkplaceBody workplaceList){
		try {
			List<String> ids = workplaceList.getIds();
			if (!Params.isBlankCollection(ids)) {
				OperationResult result = workplaceService.delete(ids);
				return Results.oprResult(result);
			} else {
				return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
			}
		} catch (GiftBusinessException e){
			LOGGER.error("删除部门操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_DELETE_WORKPLACE.toString(), null);
		} catch (Exception e) {
			LOGGER.error("删除部门操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/action/modify.do", method = RequestMethod.POST)
	public OperationResult modify(HttpServletRequest request,
			@RequestBody WorkplaceBody workplaceList){
		try {
			Workplace newWplace = workplaceList.getNewObj();
			Workplace oldWplace = workplaceList.getOldObj();
			if (Params.isNull(newWplace, oldWplace)) {
				return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
			}
			OperationResult result = workplaceService.modify(newWplace, oldWplace);
			return result;
		} catch (GiftBusinessException e){
			LOGGER.error("修改工作地操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_MODIFY_WORKPLACE.toString(), null);
		} catch (Exception e) {
			LOGGER.error("修改工作地操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/action/search.do", method = RequestMethod.POST)
	public OperationResult search(HttpServletRequest request){
		OperationResult result = new OperationResult();
		try {
			result = workplaceService.search();
			return Results.oprResult(result);
		} catch (GiftBusinessException e){
			LOGGER.error("添加部门操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_SEARCH_WORKPLACE.toString(), null);
		} catch (Exception e) {
			LOGGER.error("添加部门操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}
}
