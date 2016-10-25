package com.inspur.gift.servlet;

import java.io.File;
import java.net.URISyntaxException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 配置文件修改检测类.
 *
 * @author gao.fei
 */
public abstract class FileWatchdog extends Thread {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(FileWatchdog.class);
	/**
	 * 监测周期.
	 */
	private static final long DELAY = 1 * 1000L;
	/**
	 * 文件路径.
	 */
	private String filePath = "";
	/**
	 * 文件对象.
	 */
	private File file;
	/**
	 * 文件最后修改时间.
	 */
	private long lastModif;
	/**
	 * 是否已打印警告信息.
	 */
	private boolean warnedAlready;
	/**
	 * 是否停止文件监测.
	 */
	private boolean interrupted;

	/**
	 * 获取配置文件路径.
	 *
	 * @return 配置文件路径
	 */
	public String getFilePath() {
		return this.filePath;
	}

	/**
	 * 构造函数.
	 */
	protected FileWatchdog() {
		super("FileWatchdog");
		lastModif = 0L;
		warnedAlready = false;
		interrupted = false;
		try {
			filePath = this.getClass().getResource("/").toURI().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		filePath = StringUtils.replace(filePath, "WEB-INF/classes", ""); // 为调试方便、放到应用服务根目录下
		LOGGER.info("filePath:" + filePath);
		if (!StringUtils.endsWith(filePath, File.separator)) {
			filePath = filePath + File.separator;
		}
		filePath = filePath + this.getFileName();
		String osType = System.getProperty("os.name");
		LOGGER.info("OS Type:" + osType);
		if (StringUtils.containsIgnoreCase(osType, "win")) {
			filePath = StringUtils.replaceOnce(filePath, "/", "");
			filePath = StringUtils.replace(filePath, "/", File.separator);
		}
		filePath = StringUtils.replace(filePath, File.separator
				+ File.separator, File.separator);
		file = new File(filePath);
		// 设置为后台进程
		setDaemon(true);
	}

	/**
	 * 抽象函数获取要监测的配置文件的文件名称.
	 *
	 * @return 要监测的配置文件的文件名称
	 */
	protected abstract String getFileName();

	/**
	 * 重新加载log4j配置文件.
	 */
	protected abstract void reloadConfigFile();

	/**
	 * 停止对配置文件的监测.
	 */
	public void stopWatch() {
		this.interrupted = true;
	}

	/**
	 * 执行执行的方法.
	 */
	public void run() {
		while (!interrupted) {
			try {
				// 检查的修改时间间隔
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				LOGGER.error(e.getStackTrace());
			}
			// 检查log4j配置
			boolean fileExists = false;
			// 检查文件是否存在，
			try {
				fileExists = file.exists();
			} catch (SecurityException e) {
				LOGGER.warn("Was not allowed to read check file existance, file:["
						+ filePath + "].");
				interrupted = true;
				return;
			}
			// 如果存在获取最后修改时间与内存记录的原最后修改时间比较
			if (fileExists) {
				long l = file.lastModified();
				if (l > lastModif) {
					LOGGER.info("file[" + filePath
							+ "] modified, reload configration");
					lastModif = l;
					reloadConfigFile();
					warnedAlready = false;
				}
			} else if (!warnedAlready) {
				LOGGER.warn("[" + filePath + "] does not exist.");
				warnedAlready = true;
			}
		}
	}
}
