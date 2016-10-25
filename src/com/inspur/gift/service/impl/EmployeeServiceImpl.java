package com.inspur.gift.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspur.gift.dao.EmployeeDao;
import com.inspur.gift.model.Employee;
import com.inspur.gift.service.EmployeeService;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.Params;
import com.inspur.gift.util.ResultCode;
import com.inspur.gift.util.Results;
import com.inspur.gift.util.exception.GiftBusinessException;
import com.inspur.gift.util.exception.GiftDBException;
import com.inspur.gift.util.tool.TimeUtils;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	private static final Log LOGGER = LogFactory.getLog(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public OperationResult search(Employee employee) throws GiftBusinessException {
		try {
			if (Params.isNull(employee)) {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_ERROR.toString(), null)	;
			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", employee.getName());
			map.put("mailbox", employee.getMailbox());
			String data = TimeUtils.getInstance().Mounth();
			Criterion criterion = Restrictions.and(Restrictions.allEq(map),
					Restrictions.like("birthday", data, MatchMode.ANYWHERE));
			List<Employee> list = employeeDao.list(criterion);
			return Results.result(true, null, list);
		} catch (GiftDBException e) {
			LOGGER.error("判断员工是否存在操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("判断员工是否存在业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
		
	}

}
