package com.inspur.gift.service;

import com.inspur.gift.model.Employee;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.exception.GiftBusinessException;

/**
 * 用户登陆业务操作接口
 * @author gzc
 *
 */
public interface LoginService {

	/**
	 * 判断生日员工是否有权限登陆
	 * @param employee 生日员工
	 * @return OperationResult
	 * @throws GiftBusinessException 异常类型
	 */
	public OperationResult login(Employee employee) throws GiftBusinessException;
}
