package com.inspur.gift.service;

import java.util.List;

import com.inspur.gift.model.GiftOrder;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.exception.GiftBusinessException;

public interface OrderService {

	public OperationResult save(GiftOrder giftOrder) throws GiftBusinessException;

	public OperationResult delete(List<String> ids) throws GiftBusinessException;
	
	public OperationResult search(GiftOrder giftOrder) throws GiftBusinessException;

	public OperationResult search() throws GiftBusinessException;
}
