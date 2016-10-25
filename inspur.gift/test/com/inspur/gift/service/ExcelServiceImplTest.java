package com.inspur.gift.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.inspur.gift.service.impl.ExcelServiceImpl;
import com.inspur.gift.util.exception.GiftBusinessException;

public class ExcelServiceImplTest {
	/**
	 * ApplicationContext object.
	 */
	ApplicationContext cxt = null;

	/**
	 * DBService object.
	 */
	private ExcelService excelService;

	@Before
	public void setUp() throws Exception {
		if (cxt == null) {
			cxt = new FileSystemXmlApplicationContext(
					"/WebContent/WEB-INF/spring-configuration/applicationContext-junit.xml");
			excelService = (ExcelServiceImpl) cxt.getBean("excelService");
		}
	}
	
	@Test
	public void testImportPeople(){
		try {
			excelService.importPeople();
		} catch (GiftBusinessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testImportOrder(){
		try {
			excelService.importOrder();
		} catch (GiftBusinessException e) {
			e.printStackTrace();
		}
	}
}
