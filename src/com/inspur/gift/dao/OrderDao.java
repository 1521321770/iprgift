package com.inspur.gift.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.inspur.gift.model.Orders;

@Repository("orderDao")
public class OrderDao extends BaseDao<Orders, String>{

	/**
	 * 获取当前Session
	 * @return 当前Session
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}