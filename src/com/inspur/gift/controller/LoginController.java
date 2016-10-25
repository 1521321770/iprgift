package com.inspur.gift.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspur.gift.model.Employee;
import com.inspur.gift.service.LoginService;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.exception.GiftBusinessException;

/**
 * 生日员工登陆
 * @author gzc
 */
@Controller
@RequestMapping("/gift")
public class LoginController {

	/**
	 * 日志记录
	 */
	private static final Log LOGGER = LogFactory.getLog(LoginController.class);

	@Autowired
	private LoginService loginService;

	/**
	 * 导入员工到数据库操作
	 * @return OperationResult 成功返回true，失败返回false
	 */
	@ResponseBody
	@RequestMapping(value = "/employee/birthday/action/login.do", method = RequestMethod.POST)
	public OperationResult importEmployee(HttpServletRequest request,
    		@RequestParam(value = "name", required = true) String name,
    		@RequestParam(value = "mailbox", required = true) String mailbox,
    		@RequestParam(value = "bumen", required = true) String bumen){
		try {
			Employee employee = new Employee();
			employee.setName(name);
			employee.setBumen(bumen);
			employee.setMailbox(mailbox);
			OperationResult result = loginService.login(employee);
			return result;
		} catch (GiftBusinessException e) {
			LOGGER.error("判断用户登陆操作，业务处理失败");
			e.printStackTrace();
			return new OperationResult(false);
		} catch (Exception e) {
			LOGGER.error("判断用户登陆操作，出现异常");
			e.printStackTrace();
			return new OperationResult(false);
		}
	}
}
