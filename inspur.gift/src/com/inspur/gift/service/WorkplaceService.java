package com.inspur.gift.service;

import java.util.List;

import com.inspur.gift.bean.WorkplaceInfo;
import com.inspur.gift.model.Workplace;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.exception.GiftBusinessException;

/**
 * 工作地增、删、改、查业务操作接口
 * @author gzc
 *
 */
public interface WorkplaceService {

	/**
	 * 添加工作地信息
	 * @param Workplace Workplace对象
	 * @return OperationResult
	 * @throws GiftBusinessException 异常类型
	 */
	public OperationResult addWorkplace(Workplace workplace) throws GiftBusinessException;

	/**
	 * 删除工作地
	 * @param lsit 待删除部门id集合
	 * @return OperationResult
	 * @throws GiftBusinessException 异常类型
	 */
	public OperationResult delete(List<String> ids) throws GiftBusinessException;

	/**
	 * 修改工作地
	 * @param newPlace 修改后的工作地信息
	 * @param oldPlace 修改前的工作地信息
	 * @return OperationResult
	 * @throws GiftBusinessException 异常类型
	 */
	public OperationResult modify(Workplace newPlace, Workplace oldPlace) throws GiftBusinessException;

	/**
	 * 查看工作地信息
	 * @return OperationResult
	 * @throws GiftBusinessException 异常类型
	 */
	public OperationResult search() throws GiftBusinessException;

	/**
	 * 封装工作地信息，用于前端显示
	 * @param list
	 * @return
	 * @throws GiftBusinessException
	 */
	public List<WorkplaceInfo> toInfo(List<Workplace> list) throws GiftBusinessException;

	/**
	 * 查看工作地信息
	 * @return OperationResult
	 * @throws GiftBusinessException 异常类型
	 */
	public OperationResult findByConditions(String[] ids) throws GiftBusinessException;

	public OperationResult findByConditions(List<String> ids) throws GiftBusinessException;
}
