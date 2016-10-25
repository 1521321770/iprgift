package com.inspur.gift.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspur.gift.dao.GiftOrderDao;
import com.inspur.gift.model.Employee;
import com.inspur.gift.model.GiftOrder;
import com.inspur.gift.service.EmployeeService;
import com.inspur.gift.service.OrderService;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.Params;
import com.inspur.gift.util.ResultCode;
import com.inspur.gift.util.Results;
import com.inspur.gift.util.exception.GiftBusinessException;
import com.inspur.gift.util.exception.GiftDBException;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	private static final Log LOGGER = LogFactory.getLog(OrderServiceImpl.class);

	@Autowired
	private GiftOrderDao giftOrderDao;

	@Autowired
	private EmployeeService employeeService;

	@Override
	public OperationResult save(GiftOrder giftOrder) throws GiftBusinessException{
		try {
			if (Params.isNull(giftOrder)) {
				return Results.result(false, ResultCode.ERROR_GIFT_PARAMETER_ERROR.toString(), "参数错误");
			}
			Employee employee = new Employee();
			employee.setName(giftOrder.getName());
			employee.setBumen(giftOrder.getBumen());
			employee.setMailbox(giftOrder.getMailbox());
			OperationResult result = employeeService.search(employee);
			if (Params.isNull(result.getResData())) {
				return Results.result(false, ResultCode.ERROR_GIFT_EMPLOYEE_NO_EXIST.toString(), "员工不存在");
			}
			Criterion criterion = Restrictions.and(Restrictions.eq("name", giftOrder.getName()),
					Restrictions.eq("mailbox", giftOrder.getMailbox()));
			List<GiftOrder> lists = giftOrderDao.list(criterion);
			if (Params.isNull(lists)) {
				giftOrderDao.save(giftOrder);
			} else {
				GiftOrder order = lists.get(0);
				order.setBumen(giftOrder.getBumen());
				order.setGift(giftOrder.getGift());
				order.setPlace(giftOrder.getPlace());
				order.setAddress(giftOrder.getAddress());
				order.setTelephone(giftOrder.getTelephone());
			}
			return Results.result(true, null, "订单保存成功");
		} catch (GiftDBException e) {
			LOGGER.error("保存员工生日礼物订单操作，数据库操作失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (GiftBusinessException e) {
			LOGGER.error("保存员工生日礼物订单操作，业务处理失败", e);
			throw new GiftBusinessException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("保存员工生日礼物订单操作，出现异常", e);
			throw new GiftBusinessException(e.getMessage(), e);
		}
		
	}

	@Override
    public OperationResult delete(List<String> ids) throws GiftBusinessException {
        try {
            String args = Params.hqlArgs(ids);
            String hql = "delete from GiftOrder g where g.id in (" + ids + ")";
//            giftOrderDao.delete(hql, new String[]{args});
            String str = "\'123123123\'";
            giftOrderDao.delete(hql, new String[]{str});
            return Results.result(true);
        } catch (GiftDBException e) {
            LOGGER.error("删除订单操作，数据库操作失败", e);
            throw new GiftBusinessException(e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("删除订单操作，出现异常", e);
            throw new GiftBusinessException(e.getMessage(), e);
        }
    }

	@Override
	public OperationResult search(GiftOrder giftOrder)
			throws GiftBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public OperationResult search() throws GiftBusinessException{
        try {
            Criterion criterion = null;
            List<GiftOrder> list = giftOrderDao.list(criterion);
            return Results.result(true, null, list);
        } catch (GiftDBException e) {
            LOGGER.error("保存员工生日礼物订单操作，数据库操作失败", e);
            throw new GiftBusinessException(e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("保存员工生日礼物订单操作，出现异常", e);
            throw new GiftBusinessException(e.getMessage(), e);
        }
    }
}
