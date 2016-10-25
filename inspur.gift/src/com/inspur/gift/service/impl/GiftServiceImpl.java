package com.inspur.gift.service.impl;

import java.io.Serializable;
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

import com.inspur.gift.bean.GiftInfo;
import com.inspur.gift.dao.GiftDao;
import com.inspur.gift.model.Gift;
import com.inspur.gift.model.Mapper;
import com.inspur.gift.model.Workplace;
import com.inspur.gift.service.GiftService;
import com.inspur.gift.service.MapperService;
import com.inspur.gift.service.WorkplaceService;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.PageBean;
import com.inspur.gift.util.Params;
import com.inspur.gift.util.ResultCode;
import com.inspur.gift.util.Results;
import com.inspur.gift.util.exception.GiftBusinessException;
import com.inspur.gift.util.exception.GiftDBException;

@Service("giftService")
public class GiftServiceImpl implements GiftService{

	private static final Log LOGGER = LogFactory.getLog(GiftServiceImpl.class);

	@Autowired
	private GiftDao giftDao;

	@Autowired
	private MapperService mapperService;

	@Autowired
	private WorkplaceService workplaceService;

	@Override
	public OperationResult addGift(Gift gift, String[] wPlaces) throws GiftBusinessException {
		try {
			if (Params.isNull(gift, wPlaces)) {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString());
			}
			Criterion criterion = null;
			criterion = Restrictions.and(
					Restrictions.eq("name", gift.getName()), Restrictions.eq("flag", "1"));
			List<Gift> list = giftDao.list(criterion);
			if (!Params.isBlankCollection(list)) {
				return Results.result(false, ResultCode.ERROR_GIFT_GIFT_EXIST.toString());
			}
			Serializable uuid = giftDao.save(gift);
			OperationResult reult = mapperService.save(uuid.toString(), wPlaces);
			return reult;
		} catch (GiftDBException e) {
			LOGGER.error("添加礼物业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("添加礼物业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public OperationResult delete(List<String> ids) throws GiftBusinessException {
		try {
			if (Params.isBlankCollection(ids)) {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString());
			}
			for (String id : ids) {
				Criterion criterion = Restrictions.and(
						Restrictions.eqProperty("id", id), Restrictions.eqProperty("flag", "1"));
				List<Gift> list = giftDao.list(criterion);
				if (!Params.isBlankCollection(list)) {
					Gift gift = list.get(0);
					gift.setFlag("0");
					mapperService.delete(id);
				} else {
					return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_ERROR.toString());
				}
			}
			return Results.result(true);
		} catch (GiftDBException e) {
			LOGGER.error("删除礼物业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("删除礼物业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public OperationResult modify(Gift newGift, Gift oldGift, String[] wPlaces) throws GiftBusinessException {
		try {
			if (Params.isNull(newGift, oldGift, wPlaces)) {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString());
			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", oldGift.getId());
			map.put("name", oldGift.getName());
			map.put("flag", "1");
			Criterion criterion = Restrictions.allEq(map);
			List<Gift> list = giftDao.list(criterion);
			if (Params.isBlankCollection(list)) {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_ERROR.toString());
			}
			Gift gift = list.get(0);
			criterion = Restrictions.and(
					Restrictions.eq("name", newGift.getName()), Restrictions.eq("flag", "1"));
			list = giftDao.list(criterion);
			if (!Params.isBlankCollection(list)) {
				return Results.result(false, ResultCode.ERROR_GIFT_BUMEN_EXIST.toString());
			}
			gift.setName(newGift.getName());
			gift.setDescription(newGift.getDescription());
			OperationResult reult = mapperService.save(oldGift.getId(), wPlaces);
			return reult;
		} catch (GiftDBException e) {
			LOGGER.error("修改礼物业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("修改礼物业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	@SuppressWarnings("rawtypes")
	public OperationResult search(PageBean pageBean) throws GiftBusinessException {
		try {
			Criterion criterion = Restrictions.eq("flag", "1");
			List<Gift> list = giftDao.list(criterion);
			List<GiftInfo> listInfo = this.toInfo(list);
			return Results.result(true, null, listInfo);
		} catch (GiftDBException e) {
			LOGGER.error("查看礼物业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("查看礼物业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public OperationResult search(String id) throws GiftBusinessException {
		try {
			if (Params.isNull(id)) {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_ERROR.toString());
			}
			List<Gift> list = giftDao.list(id);
			List<GiftInfo> listInfo = this.toInfo(list);
			return Results.result(true, null, listInfo);
		} catch (GiftDBException e) {
			LOGGER.error("查看礼物业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("查看礼物业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	
	@Override
	@SuppressWarnings("rawtypes")
	public OperationResult search(String id, PageBean pageBean) throws GiftBusinessException {
		try {
			Criterion criterion = Restrictions.eq("flag", "1");
			List<Gift> list = giftDao.list(criterion);
			List<GiftInfo> listInfo = this.toInfo(list);
			return Results.result(true, null, listInfo);
		} catch (GiftDBException e) {
			LOGGER.error("查看礼物业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("查看礼物业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public List<GiftInfo> toInfo(List<Gift> list) throws GiftBusinessException {
		try {
			List<GiftInfo> listInfo = new ArrayList<GiftInfo>();
			if (list != null && list.size() >= 1) {
				for (Gift gift : list) {
					GiftInfo giftInfo = new GiftInfo();
					giftInfo.setId(gift.getId());
					giftInfo.setName(gift.getName());
					giftInfo.setCreaterId(gift.getCreaterId());
					giftInfo.setCreaterName("");
					giftInfo.setDescription(gift.getDescription());
					giftInfo.setImgUrl(gift.getImgUrl());
					giftInfo.setCreateTime(gift.getCreateTime());
					giftInfo.setUpdateTime(gift.getUpdateTime());
//					String places = this.setPlaces(gift.getId());
//					if (Params.isNull(false, places)) {
//						return null;
//					}
//					giftInfo.setPlaces(places);
					listInfo.add(giftInfo);
				}
			}
			return listInfo;
//		} catch (GiftBusinessException e) {
//			LOGGER.error("查看礼物业务操作，业务操作失败", e);
//			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("查看业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public String setPlaces(String id) throws GiftBusinessException {
		try {
			if (Params.isNull(id)) {
				return null;
			}
			List<Mapper> mapperList = mapperService.findByPid(id);
			List<String> fidList = new ArrayList<String>();
			for (Mapper mapper : mapperList) {
				String fid = mapper.getfKey();
				fidList.add(fid);
			}
			OperationResult result = workplaceService.findByConditions(fidList);
			List<Workplace> placeList = (List<Workplace>) result.getResData();
			String places = "";
			for (Workplace wPlace : placeList) {
				places +=  wPlace.getName();
			}
			return places;
		} catch (GiftBusinessException e) {
			LOGGER.error("设置工作地业务操作，业务操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("设置工作地业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}
}
