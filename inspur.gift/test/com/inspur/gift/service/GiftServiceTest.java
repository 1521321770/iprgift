package com.inspur.gift.service;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.inspur.gift.model.Gift;
import com.inspur.gift.util.exception.GiftBusinessException;

public class GiftServiceTest {

	/**
	 * ApplicationContext object.
	 */
	ApplicationContext cxt = null;

	/**
	 * DBService object.
	 */
	private  GiftService giftService;

	@Before
	public void setUp() throws Exception {
		if (cxt == null) {
			cxt = new FileSystemXmlApplicationContext(
					"/WebContent/WEB-INF/spring-configuration/applicationContext-junit.xml");
			giftService = (GiftService) cxt.getBean("giftService");
		}
	}

	@Test
	public void testImportPeople(){
		try {
			Date date = new Date();
			Gift gift = new Gift();
			gift.setImgUrl("1");
			gift.setName("飞机");
			gift.setFlag("1");
			gift.setCreateTime(date);
			gift.setUpdateTime(date);
			giftService.addGift(gift,
					new String[]{"4028f88153215449015321544f5d0001",
					"4028f88153215449015321544fc30002"});
			
			gift.setName("大炮");
			giftService.addGift(gift,
					new String[]{"4028f88153215449015321544eec0000",
					"4028f88153215449015321544fc30002"});
			
			gift.setName("坦克");
			giftService.addGift(gift,
					new String[]{"4028f88153215449015321544eec0000",
					"4028f88153215449015321544f5d0001"});
			
			gift.setName("房子");
			giftService.addGift(gift,
					new String[]{"4028f88153215449015321544f5d0001",
					"4028f88153215449015321544fc30002"});
			
			gift.setName("汽车");
			giftService.addGift(gift,
					new String[]{"4028f88153215449015321544eec0000",
					"4028f88153215449015321544fc30002"});
			
			gift.setName("美女");
			giftService.addGift(gift,
					new String[]{"4028f88153215449015321544eec0000",
					"4028f88153215449015321544f5d0001"});
		} catch (GiftBusinessException e) {
			e.printStackTrace();
		}
	}
}
