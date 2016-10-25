package com.inspur.gift.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspur.gift.dao.MapperDao;
import com.inspur.gift.model.Mapper;
import com.inspur.gift.service.MapperService;
import com.inspur.gift.service.WorkplaceService;
import com.inspur.gift.util.EnumTypes.MapperType;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.Params;
import com.inspur.gift.util.ResultCode;
import com.inspur.gift.util.Results;
import com.inspur.gift.util.exception.GiftBusinessException;
import com.inspur.gift.util.exception.GiftDBException;

@Service("mapperService")
public class MapperServiceImpl implements MapperService{

	private static final Log LOGGER = LogFactory.getLog(MapperServiceImpl.class);

	@Autowired
	private WorkplaceService workplaceService;

	@Autowired
	private MapperDao mapperDao;

	@Override
	public OperationResult save(String id, String[] wPlaces) throws GiftBusinessException {
		try {
			if (Params.isNull(id, wPlaces)) {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString());
			}

			OperationResult result = workplaceService.findByConditions(wPlaces);
			if (!result.getFlag()) {
				return result;
			}

			this.delete(id);
			for (String placeId : wPlaces) {
				Mapper mapper = new Mapper();
				mapper.setpKey(id);
				mapper.setfKey(placeId);
				mapper.setType(MapperType.gift.toString());
				mapperDao.save(mapper);
			}
			return Results.result(true);
		} catch (GiftDBException e) {
			LOGGER.error("添加礼物映射业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (GiftBusinessException e) {
			LOGGER.error("添加礼物映射业务操作，业务操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("添加礼物映射业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(String id) throws GiftBusinessException {
		try {
			String hql = "delete from Mapper m where m.id = ? and m.type = ?";
			String[] args = {id, MapperType.gift.toString()};
			mapperDao.delete(hql, args);
		} catch (GiftDBException e) {
			LOGGER.error("删除礼物映射业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("删除礼物映射业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public List<Mapper> findByPid(String pid) throws GiftBusinessException {
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("pKey", pid);
			map.put("flag", "1");
			map.put("type", MapperType.gift.toString());
			Criterion criterion = Restrictions.allEq(map);
			List<Mapper> list = mapperDao.list(criterion);
			return list;
		} catch (GiftDBException e) {
			LOGGER.error("根据Pid查找映射业务操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("根据Pid查找映射业务操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
	}
}
