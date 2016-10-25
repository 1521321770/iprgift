package com.inspur.gift.service;

import java.util.List;

import com.inspur.gift.model.Mapper;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.exception.GiftBusinessException;

public interface MapperService {

	public OperationResult save(String id, String[] wPlaces) throws GiftBusinessException;

	public void delete(String id) throws GiftBusinessException;

	public List<Mapper> findByPid(String pid) throws GiftBusinessException;
}
