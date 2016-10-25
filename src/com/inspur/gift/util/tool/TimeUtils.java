package com.inspur.gift.util.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class TimeUtils extends DateUtils{
	
	/**
	 * 创建ImportOperation对象
	 */
	private static TimeUtils instance = null;

	public static TimeUtils getInstance() {
		if (instance == null){
			instance = new TimeUtils();
		}
		return instance;
    }

	/**
	 * 获取本年本月，eg:201512,201601
	 * @return 本年本月
	 */
	public String All() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -0);  
	    Date date = calendar.getTime();
	    String mouth = sdf.format(date);
	    return mouth;
	}

	/**
	 * 获取本年当前月份，eg:12月,01月
	 * @return 本年月份
	 */
	public String getMounth() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -0);  
	    Date date = calendar.getTime();
	    String mouth = sdf.format(date);
	    return mouth;
	}

	/**
	 * 获取本年当前月份，eg:-12-月,-01-月
	 * @return 本年月份
	 */
	public String Mounth() {
		SimpleDateFormat sdf = new SimpleDateFormat("-MM-");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -0);  
	    Date date = calendar.getTime();
	    String mouth = sdf.format(date);
	    return mouth;
	}

	/**
	 * 获取本年当前月份，eg:-12-23月,-01-04月
	 * @return 本年月份
	 */
	public String MounthAndDay(int i) {
		SimpleDateFormat sdf = new SimpleDateFormat("-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -i);  
	    Date date = calendar.getTime();
	    String mouth = sdf.format(date);
	    return mouth;
	}

	public Date getDate() {
		Date date = new Date();
		return date;
	}
}
