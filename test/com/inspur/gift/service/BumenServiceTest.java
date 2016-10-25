package com.inspur.gift.service;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.inspur.gift.model.Bumen;
import com.inspur.gift.util.exception.GiftBusinessException;

public class BumenServiceTest {

	/**
	 * ApplicationContext object.
	 */
	ApplicationContext cxt = null;

	/**
	 * DBService object.
	 */
	private  BumenService bumenService;

	@Before
	public void setUp() throws Exception {
		if (cxt == null) {
			cxt = new FileSystemXmlApplicationContext(
					"/WebContent/WEB-INF/spring-configuration/applicationContext-junit.xml");
			bumenService = (BumenService) cxt.getBean("bumenService");
		}
	}

	@Test
	public void testImportPeople(){
		try {
			Date date = new Date();
			Bumen bumen = new Bumen();
			bumen.setName("AS18000项目组");
			bumen.setFlag("1");
			bumen.setCreateTime(date);
			bumen.setUpdateTime(date);
			bumenService.addBumen(bumen);
			
			bumen.setName("AS18000项目组");
			bumenService.addBumen(bumen);
			
			bumen.setName("IOP项目组");
			bumenService.addBumen(bumen);
			
			bumen.setName("IT规划处");
			bumenService.addBumen(bumen);
			
			bumen.setName("VIT");
			bumenService.addBumen(bumen);
			
			bumen.setName("采购部");
			bumenService.addBumen(bumen);
			
			bumen.setName("测试验证部");
			bumenService.addBumen(bumen);
			
			bumen.setName("产品工程部");
			bumenService.addBumen(bumen);
			
			bumen.setName("产品研发部");
			bumenService.addBumen(bumen);
			
			bumen.setName("存储产品部");
			bumenService.addBumen(bumen);
			
			bumen.setName("存储研发部");
			bumenService.addBumen(bumen);
			
			bumen.setName("存储研发部AS18000项目组");
			bumenService.addBumen(bumen);
			
			bumen.setName("服务器产品部");
			bumenService.addBumen(bumen);
			
			bumen.setName("高端服务器研发部");
			bumenService.addBumen(bumen);
			
			bumen.setName("高端计算机产品部");
			bumenService.addBumen(bumen);
			
			
			bumen.setName("高性能服务器产品部");
			bumenService.addBumen(bumen);
			
			bumen.setName("海外支持部");
			bumenService.addBumen(bumen);
			
			
			
			bumen.setName("机构设计部");
			bumenService.addBumen(bumen);
			
			bumen.setName("技术管理部");
			bumenService.addBumen(bumen);
			
			bumen.setName("技术推进部");
			bumenService.addBumen(bumen);
			
			bumen.setName("解决方案部");
			bumenService.addBumen(bumen);
			
			bumen.setName("客户服务部");
			bumenService.addBumen(bumen);
			
			bumen.setName("渠道推进部");
			bumenService.addBumen(bumen);
			
			bumen.setName("商务运营部");
			bumenService.addBumen(bumen);
			
			bumen.setName("生产部");
			bumenService.addBumen(bumen);
			
			bumen.setName("市场推进部");
			bumenService.addBumen(bumen);
			
			bumen.setName("系统软件部");
			bumenService.addBumen(bumen);
			
			bumen.setName("销售管理部");
			bumenService.addBumen(bumen);
			
			bumen.setName("信息安全事业部");
			bumenService.addBumen(bumen);
			
			bumen.setName("虚拟化项目组");
			bumenService.addBumen(bumen);
			
			bumen.setName("许昌合资公司");
			bumenService.addBumen(bumen);
			
			bumen.setName("云产品部");
			bumenService.addBumen(bumen);
			
			bumen.setName("质量管理部");
			bumenService.addBumen(bumen);
			
			bumen.setName("综合管理部");
			bumenService.addBumen(bumen);
		} catch (GiftBusinessException e) {
			e.printStackTrace();
		}
	}
}
