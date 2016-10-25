package com.inspur.gift.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.inspur.gift.model.Employee;

@Repository("excelDao")
public class ExcelDao extends BaseDao<Employee, String>{

	/**
	 * 获取当前Session
	 * @return 当前Session
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
