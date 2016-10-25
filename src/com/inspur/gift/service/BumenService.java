package com.inspur.gift.service;

import java.util.List;

import com.inspur.gift.bean.BumenInfo;
import com.inspur.gift.model.Bumen;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.exception.GiftBusinessException;

/**
 * 部门增、删、改、查业务操作接口
 * @author gzc
 *
 */
public interface BumenService {

	/**
	 * 添加Bumen信息
	 * @param bumen Bumen对象
	 * @return OperationResult
	 * @throws GiftBusinessException 异常类型
	 */
	public OperationResult addBumen(Bumen bumen) throws GiftBusinessException;

	/**
	 * 删除部门
	 * @param lsit 待删除部门id集合
	 * @return OperationResult
	 * @throws GiftBusinessException 异常类型
	 */
	public OperationResult delete(List<String> ids) throws GiftBusinessException;

	/**
	 * 修改部门信息
	 * @param newBumen 修改后的部门信息
	 * @param oldBumen 修改前的部门信息
	 * @return OperationResult
	 * @throws GiftBusinessException 异常类型
	 */
	public OperationResult modify(Bumen newBumen, Bumen oldBumen) throws GiftBusinessException;

	/**
	 * 查看部门信息
	 * @return OperationResult
	 * @throws GiftBusinessException 异常类型
	 */
	public OperationResult search() throws GiftBusinessException;

	/**
	 * 封装部门信息，用于前端显示
	 * @param list
	 * @return
	 * @throws GiftBusinessException
	 */
	public List<BumenInfo> toInfo(List<Bumen> list) throws GiftBusinessException;
}
