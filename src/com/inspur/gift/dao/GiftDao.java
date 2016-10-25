package com.inspur.gift.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.inspur.gift.model.Gift;
import com.inspur.gift.util.EnumTypes.MapperType;
import com.inspur.gift.util.exception.GiftDBException;

@Repository("giftDao")
public class GiftDao extends BaseDao<Gift, String>{

	/**
	 * 日志
	 */
	private static final Log LOGGER = LogFactory.getLog(GiftDao.class);

	@SuppressWarnings("unchecked")
	public List<Gift> list(String id) throws GiftDBException {
		try {
//			Criteria criteria = getSession().createCriteria(Gift.class, "g");
//			criteria.createAlias("Mapper", "m");
//			criteria.add(Restrictions.eq("m.fKey", id));
//			criteria.add(Restrictions.eq("m.pKey", "g.id"));
//			criteria.add(Restrictions.eq("m.type", MapperType.gift.toString()));
//			criteria.add(Restrictions.eq("g.flag", "1"));
//			return criteria.list();
			Session session = getSession();
			String HQL_SELECT = "select g.id, g.name, g.createrId, g.description,"
					+ " g.imgUrl, g.createTime, g.updateTime, g.flag ";
			String hql = HQL_SELECT + "from Gift g, Mapper m"
					+ " where g.flag = ? and g.id = m.pKey and m.fKey = ? and m.type = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, "1");
			query.setParameter(1, id);
			query.setParameter(2, MapperType.gift.toString());
			List<Object> objects = query.list();
			List<Gift> giftList = new ArrayList<Gift>();
			for (Object obj : objects) {
				Object[] object = (Object[]) obj;
				Gift gift = new Gift();
				gift.setId(String.valueOf(object[0]));
				gift.setName(String.valueOf(object[1]));
				gift.setCreaterId(String.valueOf(object[2]));
				gift.setDescription(String.valueOf(object[3]));
				gift.setImgUrl(String.valueOf(object[4]));
//				gift.setCreateTime(Date.valueOf(String.valueOf(object[5])));
//				gift.setUpdateTime(Date.valueOf(String.valueOf(object[6])));
				gift.setFlag(String.valueOf(object[7]));
				giftList.add(gift);
			}
			return giftList;
		} catch (Exception e) {
			LOGGER.error("List<Gift> failed." + id, e);
			throw new GiftDBException(e.getMessage(), e);
		}
	}
}
