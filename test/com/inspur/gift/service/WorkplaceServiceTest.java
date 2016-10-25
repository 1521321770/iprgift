package com.inspur.gift.service;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.inspur.gift.model.Bumen;
import com.inspur.gift.model.Workplace;
import com.inspur.gift.util.exception.GiftBusinessException;

public class WorkplaceServiceTest {

	/**
	 * ApplicationContext object.
	 */
	ApplicationContext cxt = null;

	/**
	 * DBService object.
	 */
	private  WorkplaceService workplaceService;

	@Before
	public void setUp() throws Exception {
		if (cxt == null) {
			cxt = new FileSystemXmlApplicationContext(
					"/WebContent/WEB-INF/spring-configuration/applicationContext-junit.xml");
			workplaceService = (WorkplaceService) cxt.getBean("workplaceService");
		}
	}

	@Test
	public void testImportPeople(){
		try {
			Date date = new Date();
			Workplace workplace = new Workplace();
			workplace.setName("郑州");
			workplace.setFlag("1");
			workplace.setCreateTime(date);
			workplace.setUpdateTime(date);
			workplaceService.addWorkplace(workplace);
			
			workplace.setName("济南");
			workplaceService.addWorkplace(workplace);
			
			workplace.setName("其他");
			workplaceService.addWorkplace(workplace);
		} catch (GiftBusinessException e) {
			e.printStackTrace();
		}
	}
}
