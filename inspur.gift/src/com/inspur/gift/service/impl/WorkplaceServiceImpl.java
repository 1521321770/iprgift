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

import com.inspur.gift.bean.WorkplaceInfo;
import com.inspur.gift.dao.WorkplaceDao;
import com.inspur.gift.model.Workplace;
import com.inspur.gift.service.WorkplaceService;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.Params;
import com.inspur.gift.util.ResultCode;
import com.inspur.gift.util.Results;
import com.inspur.gift.util.exception.GiftBusinessException;
import com.inspur.gift.util.exception.GiftDBException;

@Service("workplaceService")
public class WorkplaceServiceImpl implements WorkplaceService {

	/**
	 * 日志操作
	 */
	private static final Log LOGGER = LogFactory.getLog(WorkplaceServiceImpl.class);

	@Autowired
	private WorkplaceDao workplaceDao;

	@Override
	public OperationResult addWorkplace(Workplace workplace)
			throws GiftBusinessException {
		try {
			if (Params.isNull(workplace)) {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_ERROR.toString());
			}
			Criterion criterion = Restrictions.and(
					Restrictions.eq("name", workplace.getName()), Restrictions.eq("flag", "1"));
			List<Workplace> list = workplaceDao.list(criterion);
			if (!Params.isBlankCollection(list)) {
				return Results.result(false, ResultCode.ERROR_GIFT_WORKPLACE_EXIST.toString());
			}
			workplaceDao.save(workplace);
			return Results.result(true);
		} catch (GiftDBException e) {
			LOGGER.error("添加工作地业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("添加工作地业务操作，出现异常", e);
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
					List<Workplace> list = workplaceDao.list(criterion);
					if (!Params.isBlankCollection(list)) {
						Workplace wPlace = list.get(0);
						wPlace.setFlag("0");
					} else {
						return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_ERROR.toString());
					}
				}
			} else {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString());
			}
			return Results.result(true);
		} catch (GiftDBException e) {
			LOGGER.error("删除工作地业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("删除工作地业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public OperationResult modify(Workplace newPlace, Workplace oldPlace) throws GiftBusinessException {
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", oldPlace.getId());
			map.put("name", oldPlace.getName());
			map.put("flag", "1");
			Criterion criterion = Restrictions.allEq(map);
			List<Workplace> list = workplaceDao.list(criterion);
			if (Params.isBlankCollection(list)) {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_ERROR.toString());
			}
			Workplace wplace = list.get(0);
			criterion = Restrictions.and(
					Restrictions.eq("name", newPlace.getName()), Restrictions.eq("flag", "1"));
			list = workplaceDao.list(criterion);
			if (!Params.isBlankCollection(list)) {
				return Results.result(false, ResultCode.ERROR_GIFT_WORKPLACE_EXIST.toString());
			}
			wplace.setName(newPlace.getName());
			return Results.result(true);
		} catch (GiftDBException e) {
			LOGGER.error("修改工作地业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("修改工作地业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public OperationResult search() throws GiftBusinessException {
		try {
			Criterion criterion = Restrictions.eq("flag", "1");
			List<Workplace> list = workplaceDao.list(criterion);
			List<WorkplaceInfo> listInfo = this.toInfo(list);
			return Results.result(true, null, listInfo);
		} catch (GiftDBException e) {
			LOGGER.error("查看工作地业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("查看工作地业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public List<WorkplaceInfo> toInfo(List<Workplace> list) throws GiftBusinessException {
		List<WorkplaceInfo> listInfo = new ArrayList<WorkplaceInfo>();
		if (list != null && list.size() >= 1) {
			for (Workplace wplace : list) {
				WorkplaceInfo workplaceInfo = new WorkplaceInfo();
				workplaceInfo.setId(wplace.getId());
				workplaceInfo.setName(wplace.getName());
				workplaceInfo.setCreaterId(wplace.getCreaterId());
				workplaceInfo.setCreaterName("");
				workplaceInfo.setCreateTime(wplace.getCreateTime());
				workplaceInfo.setUpdateTime(wplace.getUpdateTime());
				listInfo.add(workplaceInfo);
			}
		}
		return listInfo;
	}

	@Override
	public OperationResult findByConditions(String[] ids) throws GiftBusinessException {
		try {
			List<Workplace> placeList = new ArrayList<Workplace>();
			for (String id : ids) {
				Criterion criterion = Restrictions.and(
						Restrictions.eq("id", id), Restrictions.eq("flag", "1"));
				List<Workplace> list = workplaceDao.list(criterion);
				if (Params.isBlankCollection(list)) {
					Results.result(false, ResultCode.ERROR_GIFT_WORKPLACE_NO_EXIST.toString());
				}
				placeList.add(list.get(0));
			}
			return Results.result(true,null, placeList);
		} catch (GiftDBException e) {
			LOGGER.error("判断工作地是否存在业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("判断工作地是否存在业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public OperationResult findByConditions(List<String> ids) throws GiftBusinessException {
		try {
			List<Workplace> placeList = new ArrayList<Workplace>();
			for (String id : ids) {
				Criterion criterion = Restrictions.and(
						Restrictions.eq("id", id), Restrictions.eq("flag", "1"));
				List<Workplace> list = workplaceDao.list(criterion);
				if (Params.isBlankCollection(list)) {
					Results.result(false, ResultCode.ERROR_GIFT_WORKPLACE_NO_EXIST.toString());
				}
				placeList.add(list.get(0));
			}
			return Results.result(true,null, placeList);
		} catch (GiftDBException e) {
			LOGGER.error("判断工作地是否存在业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("判断工作地是否存在业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}
}
