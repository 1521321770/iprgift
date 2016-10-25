package com.inspur.gift.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspur.gift.dao.ExcelDao;
import com.inspur.gift.dao.OrderDao;
import com.inspur.gift.model.Employee;
import com.inspur.gift.model.Orders;
import com.inspur.gift.service.ExcelService;
import com.inspur.gift.util.ImportOperation;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.exception.GiftBusinessException;
import com.inspur.gift.util.exception.GiftDBException;
import com.inspur.gift.util.tool.TimeUtils;

@Service("excelService")
public class ExcelServiceImpl implements ExcelService{

	/**
	 * Log4j日志记录对象.
	 */
	private static final Log LOGGER = LogFactory.getLog(ImportOperation.class);

	@Autowired
	private ExcelDao excelDao;

	@Autowired
	private OrderDao orderDao;

	@Override
	public OperationResult importPeople() throws GiftBusinessException {
		try {
			List<Map<String, String>> list = ImportOperation.getInstance().importMsg();
			List<Employee> employeeList = new ArrayList<Employee>();
			String mouth = TimeUtils.getInstance().MounthAndDay(0);
			for (Map<String, String> map:list) {
	            Employee employee = new Employee();
	            employee.setEmployeeId(map.get("employeeId"));
	            employee.setName(map.get("userName"));
	            employee.setBumen(map.get("bumen"));
	            employee.setBumen2(map.get("bumen2"));
	            employee.setPlace(map.get("workPlace"));
	            employee.setSex(map.get("sex"));
	            employee.setBirthday(map.get("birthday"));
	            employee.setMailbox(map.get("mailBox"));
	            employee.setMouth(mouth);
	            employeeList.add(employee);
			}
			excelDao.save(employeeList);
			return new OperationResult(true);
		} catch (GiftDBException e) {
			LOGGER.info(e.getMessage());
            e.printStackTrace();
            throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public OperationResult importOrder() throws GiftBusinessException {
		try {
			List<Map<String, String>> list = ImportOperation.getInstance().importOrder();
			List<Orders> employeeList = new ArrayList<Orders>();
			for (Map<String, String> map:list) {
				Orders orders = new Orders();
				orders.setName(map.get("userName"));
				orders.setBumen(map.get("bumen"));
				orders.setBumen2(map.get("bumen2"));
	            orders.setMailbox(map.get("mailBox"));
	            employeeList.add(orders);
			}
			orderDao.save(employeeList);
			return new OperationResult(true);
		} catch (GiftDBException e) {
			LOGGER.info(e.getMessage());
            e.printStackTrace();
            throw new GiftBusinessException(e.getMessage(), e);
		}
	}

	@Override
	public OperationResult exportOrder() throws GiftBusinessException{
		return null;
	}
}
