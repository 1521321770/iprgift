package com.inspur.gift.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspur.gift.service.ExcelService;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.exception.GiftBusinessException;

/**
 * 1、导入员工信息到数据库
 * 2、导出礼品信息到Excel表
 * @author gzc
 */
@Controller
@RequestMapping("/gift")
public class ExcelController {

	/**
	 * 日志记录
	 */
	private static final Log LOGGER = LogFactory.getLog(ExcelController.class);

	private ExcelService excelService;

	/**
	 * 导入员工到数据库操作
	 * @return OperationResult 成功返回true，失败返回false
	 */
	@ResponseBody
	@RequestMapping(value = "/employee/birthday/action/import.do", method = RequestMethod.POST)
	public OperationResult importEmployee(){
		try {
			OperationResult result = excelService.importPeople();
			return result;
		} catch (GiftBusinessException e) {
			LOGGER.error("导入人员名单操作失败");
			e.printStackTrace();
			return new OperationResult(false);
		}
	}

	/**
	 * 到出生日礼物名单到Excel表
	 * @return OperationResult 成功返回true，失败返回false
	 */
	@ResponseBody
	@RequestMapping(value = "/employee/birthday/action/export.do", method = RequestMethod.POST)
	public OperationResult exportExcel(){
		try {
			OperationResult result = excelService.importPeople();
			return result;
		} catch (GiftBusinessException e) {
			LOGGER.error("导入人员名单操作失败");
			e.printStackTrace();
			return new OperationResult(false);
		}
	}
}
