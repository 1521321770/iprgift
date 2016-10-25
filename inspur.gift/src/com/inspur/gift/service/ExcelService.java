package com.inspur.gift.service;

import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.exception.GiftBusinessException;

public interface ExcelService {
	/**
	 * 导入生日名单信息到数据库
	 * @return OperationResult
	 */
	public OperationResult importPeople() throws GiftBusinessException;

	/**
	 * 导入生日名单信息到数据库
	 * @return OperationResult
	 */
	public OperationResult importOrder() throws GiftBusinessException;

	/**
	 * 导出生日礼物订单信息到Excel表
	 * @return OperationResult
	 */
	public OperationResult exportOrder() throws GiftBusinessException;
}
