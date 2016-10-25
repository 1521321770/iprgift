package com.inspur.gift.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.inspur.gift.util.EnumTypes.Sort;

/**
 * 参数判断类
 * @author gzc
 *
 */
public class Params {

	/**
	 * 判断参数是否为空或null
	 * @param objects 需要判断的参数
	 * @return 假如null或 "",返回true
	 */
	public static boolean isNull(Object...objects) {
		for (Object object : objects) {
			if (isNullOrEmpty(object, true)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNull(boolean flag, Object object) {
		if (isNullOrEmpty(object, flag)) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNullOrEmpty(Object obj, boolean flag) {  
        if (obj == null)  
            return true;  

        if ("".equals(obj) && flag) {
        	return true;
        }

        if (obj instanceof CharSequence)  
            return ((CharSequence) obj).length() == 0;  
  
        if (obj instanceof Collection)  
            return ((Collection) obj).isEmpty();  
  
        if (obj instanceof Map)  
            return ((Map) obj).isEmpty();  
  
        if (obj instanceof Object[]) {  
            Object[] object = (Object[]) obj;  
            if (object.length == 0) {  
                return true;  
            }  
            boolean empty = true;  
            for (int i = 0; i < object.length; i++) {  
                if (!isNullOrEmpty(object[i], flag)) {  
                    empty = false;  
                    break;  
                }  
            }  
            return empty;  
        }  
        return false;  
    }

	/**
	 * 判断集合是否为空
	 * @param c 集合对象，例如 List、Map
	 * @return null或空，返回true，反之，返回false。
	 */
	public static <T> boolean isBlankCollection(Collection<T> c) {
		if (c == null || c.size() == 0 || c.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断数组是否为空
	 * @param t 数组对象，例如 String[]、Char[]
	 * @return null或空，返回true，反之，返回false。
	 */
	public static <T> boolean isArray(T[] t) {
		if(t == null || t.length == 0){
			return true;
		}
		return false;
	}

	public static boolean isSorted(String args) {
		if (args == null || "".equals(args))  
            return false;  

		return (StringUtils.equalsIgnoreCase(Sort.ASC.toString(), args) ||
        		StringUtils.equalsIgnoreCase(Sort.DESC.toString(), args));
        
	}

	/**
	 * 参数转换为符合查询语句in里面形式.
	 * @param ids 参数集合
	 * @return String
	 */
	public static String hqlArgs(List<String> ids) {
	    StringBuilder args = new StringBuilder();
	    for (String id:ids) {
	        args.append("\'" + id + "\',");
	    }
	    String str = args.toString();
	    if (str.length() == 0) {
	        return "";
	    }
	    return StringUtils.substring(str, 0, str.length()-1);
	}
}
