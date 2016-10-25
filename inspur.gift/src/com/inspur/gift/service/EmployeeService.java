package com.inspur.gift.service;

import com.inspur.gift.model.Employee;
import com.inspur.gift.model.GiftOrder;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.exception.GiftBusinessException;

public interface EmployeeService {

	public OperationResult search(Employee employee) throws GiftBusinessException;
}
