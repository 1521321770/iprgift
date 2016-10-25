package com.inspur.gift.service;

import java.util.List;

import com.inspur.gift.bean.GiftInfo;
import com.inspur.gift.model.Gift;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.PageBean;
import com.inspur.gift.util.exception.GiftBusinessException;

public interface GiftService {

	/**
	 * 添加礼物信息
	 * @param gift Gift对象
	 * @param wPlaces 工作地的id集合
	 * @return OperationResult
	 * @throws GiftBusinessException  异常类型
	 */
	public OperationResult addGift(Gift gift, String[] wPlaces) throws GiftBusinessException;

	
	public OperationResult delete(List<String> ids) throws GiftBusinessException;

	
	public OperationResult modify(Gift newGift, Gift oldGift, String[] wPlaces) throws GiftBusinessException;

	
	public OperationResult search(PageBean pageBean) throws GiftBusinessException;

	public OperationResult search(String id) throws GiftBusinessException;

	public OperationResult search(String id, PageBean pageBean) throws GiftBusinessException;

	public List<GiftInfo> toInfo(List<Gift> list) throws GiftBusinessException;

	public String setPlaces(String id) throws GiftBusinessException;
}
