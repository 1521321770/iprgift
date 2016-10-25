package com.inspur.gift.util.tool;

import java.net.URLDecoder;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PathUtil {

	private static final Log LOGGER = LogFactory.getLog(PathUtil.class);

    private static PathUtil instance = null;

    public static synchronized PathUtil getInstance() {
        if (instance == null) {
            instance = new PathUtil();
        }
        return instance;
    }

    public synchronized String getRootPath() {
    	try {
    		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    		rootPath = URLDecoder.decode(StringUtils.replace(rootPath, "/build/classes/", ""),"UTF-8");
    		rootPath = StringUtils.substring(rootPath, 1);
    		return rootPath;
    	} catch (Exception e) {
    		LOGGER.error("上传文件，根路径出现问题。");
    		return null;
    	}
    }
}
