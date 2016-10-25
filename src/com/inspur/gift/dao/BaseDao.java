package com.inspur.gift.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.inspur.gift.util.PageBean;
import com.inspur.gift.util.exception.GiftDBException;

public class BaseDao<T, PK extends Serializable> extends HibernateDaoSupport{

	/**
	 * 日志
	 */
	private static final Log LOGGER = LogFactory.getLog(BaseDao.class);

	@Autowired
	protected SessionFactory sessionFactory;

	@Autowired  
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {  
        super.setSessionFactory(sessionFactory);  
    }

	@SuppressWarnings("unchecked")
	Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	/**
	 * 获取当前Session
	 * @return 当前Session
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 获取当前类对象
	 * @return 获取Criteria
	 */
	public Criteria getCriteria() {
		return getSession().createCriteria(entityClass);
	}

	public Serializable save(T object) throws GiftDBException {
		try {
			Serializable result = getSession().save(object);
			return result;
		} catch (Exception e) {
			LOGGER.error("save T failed:" + object, e);
			throw new GiftDBException(e.getMessage(), e);
		}

	}

	public void save(List<T> list) throws GiftDBException {
		try {
			for (T object:list) {
				getSession().save(object);
			}
		} catch (Exception e) {
			LOGGER.error("save List<T> failed" + list, e);
			throw new GiftDBException(e.getMessage(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> list(Criterion criterion) throws GiftDBException {
		try {
			Criteria criteria = getCriteria();
			if(criterion != null) {
				criteria = criteria.add(criterion);
			}
			return criteria.list();
		} catch (Exception e) {
			LOGGER.error("List<T> failed" + criterion, e);
			throw new GiftDBException(e.getMessage(), e);
		}
	}

	public void delete(String hql, List<Object> args) throws GiftDBException {
		try {
			Session session = getSession();
			Query query = session.createQuery(hql);
			for (int i = 0; i < args.size(); i++) {
				query.setParameter(i, args.get(i));
			}
			query.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("delete hql failed. " + hql + " (" + args + ")", e);
			throw new GiftDBException(e.getMessage(), e);
		}
	}

	public void delete(String hql, Object[] args) throws GiftDBException {
		try {
			Session session = getSession();
			Query query = session.createQuery(hql);
			for (int i = 0; i < args.length; i++){
				query.setParameter(i, args[i]);
			}
			query.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("delete hql failed. " + hql, e);
			throw new GiftDBException(e.getMessage(), e);
		}
	}

	public void delete(String hql) throws GiftDBException {
		try {
			Session session = getSession();
			Query query = session.createQuery(hql);
			query.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("delete hql failed. " + hql, e);
			throw new GiftDBException(e.getMessage(), e);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findByConditions(Criterion criterion, Order order, PageBean pageBean) throws GiftDBException {
		try {
			Criteria criteria = getCriteria();
			if (criterion != null) {
				criteria = criteria.add(criterion);
			}

			if (order != null) {
				criteria = criteria.addOrder(order);
			}

			criteria.setProjection(Projections.rowCount()).uniqueResult();
			criteria.setProjection(null);
			criteria.setFirstResult((pageBean.getCurrentPage() - 1) * pageBean.getPageSize());
			criteria.setMaxResults(pageBean.getPageSize());
			return criteria.list();
		} catch (Exception e) {
			LOGGER.error("List<T> 查询当前页数据. " + criterion + " " + order + " " + pageBean, e);
			throw new GiftDBException(e.getMessage(), e);
		}
	}
}
