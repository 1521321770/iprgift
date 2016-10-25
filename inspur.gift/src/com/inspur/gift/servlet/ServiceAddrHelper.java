package com.inspur.gift.servlet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

/**
 * 模块服务地址帮助类.
 *
 * @author gao.fei
 */
public final class ServiceAddrHelper extends FileWatchdog {
	/**
	 * 服务地址Map.
	 */
	private static Map<String, String> addrMap = new HashMap<String, String>();
	/**
	 * 默认服务地址 -- 本地.
	 */
	private static final String DEFAULT_ADDR = "127.0.0.1"; // 默认服务地址 - 本地
	/**
	 * 各模块缩写.
	 */
	private static final String INSPUR.GIFT = "iaot", // 自动化部署模块
			IASSET = "iasset", // 资产管理模块
			ICOMPUTE = "icompute", // 自动化部署模块
			IAUTH = "iauth", // 认证模块
			IBASE = "ibase", // 基本模块
			ICHARGE = "icharge", // 计费管理模块
			IMANAGE = "imanage", // 服务器管理模块
			IMONITOR = "imonitor", // 服务器监控模块
			IRESOURCE = "iresource", // 云资源管理模块
			INETWORK = "inetwork", // 网络、防火墙模块
			ISTORAGE = "istorage", // 模板&镜像模块
			IWORK_FLOW = "iworkflow", // 业务流程管理模块
			ITROUBLE = "itrouble", // 故障管理模块
			IRESMONITOR = "iresmonitor", // 云资源的监控模块
			ICM = "icm", // ICM模块
			ISM = "ism", // ISM模块
			OPENSTRONGCONFIRM = "OPENSTRONGCONFIRM";
	/**
	 * 模块列表.
	 */
	private static final String[] MODULES = new String[] {GIFT, IASSET,
			ICOMPUTE, IAUTH, IBASE, ICHARGE, IMANAGE, IMONITOR, IRESOURCE,
			INETWORK, ISTORAGE, IWORK_FLOW, ITROUBLE, IRESMONITOR, ICM, ISM,
			OPENSTRONGCONFIRM };
	static {
		addrMap.put(IAOT, DEFAULT_ADDR);
		addrMap.put(IASSET, DEFAULT_ADDR);
		addrMap.put(ICOMPUTE, DEFAULT_ADDR);
		addrMap.put(IAUTH, DEFAULT_ADDR);
		addrMap.put(IBASE, DEFAULT_ADDR);
		addrMap.put(ICHARGE, DEFAULT_ADDR);
		addrMap.put(IMANAGE, DEFAULT_ADDR);
		addrMap.put(IMONITOR, DEFAULT_ADDR);
		addrMap.put(IRESOURCE, DEFAULT_ADDR);
		addrMap.put(INETWORK, DEFAULT_ADDR);
		addrMap.put(ISTORAGE, DEFAULT_ADDR);
		addrMap.put(IWORK_FLOW, DEFAULT_ADDR);
		addrMap.put(ITROUBLE, DEFAULT_ADDR);
		addrMap.put(IRESMONITOR, DEFAULT_ADDR);
		addrMap.put(ICM, DEFAULT_ADDR);
		addrMap.put(ISM, DEFAULT_ADDR);
		addrMap.put(OPENSTRONGCONFIRM, DEFAULT_ADDR);

	}

	/**
	 * 模块服务地址帮助类实例.
	 */
	private static ServiceAddrHelper instance = null;

	/**
	 * 全局模块存储.
	 */
	private Properties p = new Properties();

	/**
	 * 获取模块服务地址帮助类实例.
	 *
	 * @return 模块服务地址帮助类实例.
	 */
	public static synchronized ServiceAddrHelper getInstance() {
		if (instance == null) {
			instance = new ServiceAddrHelper();
		}
		return instance;
	}

	/**
	 * 默认构造函数.
	 */
	private ServiceAddrHelper() {
		super();
	}

	/**
	 * 获取模块的服务地址.
	 *
	 * @param module
	 *            模块缩写
	 * @return 模块服务地址
	 */
	public String getServiceAddr(String module) {
		synchronized (addrMap) {
			String addr = addrMap.get(module);
			if (addr == null || StringUtils.isBlank(addr)) {
				addr = p.getProperty(module, DEFAULT_ADDR).trim();
				addrMap.put(module, addr);
			}
			if (addr == null || StringUtils.isBlank(addr)) {
				return DEFAULT_ADDR;
			}
			return addr;
		}
	}

	/**
	 * 获取所有模块的服务地址.
	 *
	 * @return 所有模块服务地址
	 */
	public Map<String, String> getAllServiceAddr() {
		synchronized (addrMap) {
			return addrMap;
		}
	}

	@Override
	protected String getFileName() {
		return "serviceAddr.properties";
	}

	@Override
	protected void reloadConfigFile() {
		String filePath = this.getFilePath();

		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream(filePath));
			// Properties p = new Properties();
			p.load(in);

			synchronized (addrMap) {
				addrMap.clear();
				for (String module : MODULES) {
					addrMap.put(module, p.getProperty(module, DEFAULT_ADDR)
							.trim());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}