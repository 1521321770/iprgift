package com.inspur.gift.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspur.gift.bean.BumenInfo;
import com.inspur.gift.dao.BumenDao;
import com.inspur.gift.model.Bumen;
import com.inspur.gift.service.BumenService;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.Params;
import com.inspur.gift.util.ResultCode;
import com.inspur.gift.util.Results;
import com.inspur.gift.util.exception.GiftBusinessException;
import com.inspur.gift.util.exception.GiftDBException;

@Service("bumenService")
public class BumenServiceImpl implements BumenService {

	/**
	 * 日志操作
	 */
	private static final Log LOGGER = LogFactory.getLog(BumenServiceImpl.class);

	@Autowired
	private BumenDao bumenDao;
	
	@Override
	public OperationResult addBumen(Bumen bumen) throws GiftBusinessException {
		try {
			if (!Params.isNull(bumen)) {
				Criterion criterion = null;
				criterion = Restrictions.and(
						Restrictions.eq("name", bumen.getName()), Restrictions.eq("flag", "1"));
				List<Bumen> list = bumenDao.list(criterion);
				if (!Params.isBlankCollection(list)) {
					return Results.result(false, ResultCode.ERROR_GIFT_BUMEN_EXIST.toString());
				}
				bumenDao.save(bumen);
				return Results.result(true);
			} else {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString());
			}
		} catch (GiftDBException e) {
			LOGGER.error("添加部门业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("添加部门业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public OperationResult delete(List<String> ids) throws GiftBusinessException {
		try {
			if (!Params.isBlankCollection(ids)) {
				for (String id : ids) {
					Criterion criterion = Restrictions.and(
							Restrictions.eqProperty("id", id), Restrictions.eqProperty("flag", "1"));
					List<Bumen> list = bumenDao.list(criterion);
					if (!Params.isBlankCollection(list)) {
						Bumen bumen = list.get(0);
						bumen.setFlag("0");
					} else {
						return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_ERROR.toString());
					}
				}
			} else {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString());
			}
			return Results.result(true);
		} catch (GiftDBException e) {
			LOGGER.error("删除部门业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("删除部门业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public OperationResult modify(Bumen newBumen, Bumen oldBumen) throws GiftBusinessException {
		try {
			if (Params.isNull(newBumen, oldBumen)) {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString());
			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", oldBumen.getId());
			map.put("name", oldBumen.getName());
			map.put("flag", "1");
			Criterion criterion = Restrictions.allEq(map);
			List<Bumen> list = bumenDao.list(criterion);
			if (Params.isBlankCollection(list)) {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_ERROR.toString());
			}
			Bumen bumen = list.get(0);
			criterion = Restrictions.and(
					Restrictions.eq("name", newBumen.getName()), Restrictions.eq("flag", "1"));
			list = bumenDao.list(criterion);
			if (!Params.isBlankCollection(list)) {
				return Results.result(false, ResultCode.ERROR_GIFT_BUMEN_EXIST.toString());
			}
			bumen.setName(newBumen.getName());
			return Results.result(true);
		} catch (GiftDBException e) {
			LOGGER.error("修改部门业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("修改部门业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public OperationResult search() throws GiftBusinessException {
		try {
			Criterion criterion = null;
			criterion = Restrictions.eq("flag", "1");
			List<Bumen> list = bumenDao.list(criterion);
			List<BumenInfo> listInfo = this.toInfo(list);
			return Results.result(true, null, listInfo);
		} catch (GiftDBException e) {
			LOGGER.error("查看部门信息业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("查看部门信息业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public List<BumenInfo> toInfo(List<Bumen> list)
			throws GiftBusinessException {
		List<BumenInfo> listInfo = new ArrayList<BumenInfo>();
		if (list != null && list.size() >= 1) {
			for (Bumen bumen : list) {
				BumenInfo bumenInfo = new BumenInfo();
				bumenInfo.setId(bumen.getId());
				bumenInfo.setName(bumen.getName());
				bumenInfo.setCreaterId(bumen.getCreaterId());
				bumenInfo.setCreaterName("");
				bumenInfo.setCreateTime(bumen.getCreateTime());
				bumenInfo.setUpdateTime(bumen.getUpdateTime());
				listInfo.add(bumenInfo);
			}
		}
		return listInfo;
	}
}
