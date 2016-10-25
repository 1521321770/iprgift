package com.inspur.gift.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspur.gift.dao.LoginDao;
import com.inspur.gift.model.Employee;
import com.inspur.gift.service.LoginService;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.exception.GiftBusinessException;
import com.inspur.gift.util.exception.GiftDBException;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	private static Log LOGGER = LogFactory.getLog(LoginServiceImpl.class);

	@Autowired
	private LoginDao loginDao;

	@Override
	public OperationResult login(Employee employee)
			throws GiftBusinessException {
		OperationResult result = new OperationResult();
		try {
			Criterion criterion = null;
			criterion = Restrictions.and(Restrictions.eq("name", employee.getName()),
					Restrictions.eq("bumen", employee.getBumen()));
			List<Employee> list = loginDao.list(criterion);
			if (list.size() == 1) {
				Employee emp = list.get(0);
				emp.setMailbox(employee.getMailbox());
				result.setFlag(true);
				result.setResData(emp);
				return result;
			} else {
				result.setFlag(false);
				return result;
			}
		} catch (GiftDBException e) {
			LOGGER.error("判断用户登陆业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("判断用户登陆业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

}
