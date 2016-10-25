package com.inspur.gift.servlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

/**
 *������.
 *
 *@author gengzhichao
 */
public final class Utils {
    /**
     *Ĭ�Ϲ��캯��.
     */
    private Utils() {
    }

    /**
     *ȡ�õ�ǰ�߳���Ϣ.
     *
     *@return ��ǰ�߳���Ϣ
     */
    public static String getCurrentThreadInfo() {
        String info = Thread.currentThread().toString();
        // String info = "(Thread " + Thread.currentThread().getId() + ")";
        return info;
    }

    /**
     *��ʾ����HTTP�������.
     *
     *@param req
     *           HTTP�������
     */
    public static void showAllRequestParams(HttpServletRequest req) {
        Enumeration<String> paramNames = (Enumeration<String>) req.getParameterNames();
        if (paramNames != null) {
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                String paramValue = req.getParameter(paramName);
                System.out.print(paramName + ":" + paramValue + ",");
            }
            System.out.println();
        }
    }

    /**
     *��ʾ����HTTP header.
     *
     *@param req
     *           HTTP�������
     */
    public static void showAllHttpHeaders(HttpServletRequest req) {
        @SuppressWarnings("unchecked")
        Enumeration<String> reqHeaderNames = (Enumeration<String>) req.getHeaderNames();
        if (reqHeaderNames != null) {
            System.out.println("HTTP request headers:");
            while (reqHeaderNames.hasMoreElements()) {
                String reqHeaderName = reqHeaderNames.nextElement();
                String reqValue = req.getParameter(reqHeaderName);
                System.out.println(reqHeaderName + ":" + reqValue);
            }
        }
    }

    /**
     *����HTTP��Ӧ����.
     *
     *@param res
     *           HTTP��Ӧ����
     */
    public static void setResponseAttributes(HttpServletResponse res) {
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setHeader("Expires", "0");
        res.setHeader("Content-Type", "text/xml; charset=utf-8");
        res.setCharacterEncoding("utf-8");
    }

    /**
     *���ַ�ת��Ϊ����(����ַ�Ϊ�ջ�����֣��򷵻�0).
     *
     *@param str
     *           ��ת���ַ�
     *@return ת�������������
     */
    public static int parseInt(String str) {
        if (str != null && !"".equals(str)) {
            str = str.trim();
            if (StringUtils.isNumeric(str)) {
                return Integer.parseInt(str);
            }
        }
        return 0;
    }

    /**
     *���ַ�ת��Ϊ������(����ַ�Ϊ�ջ�����֣��򷵻�0L).
     *
     *@param str
     *           ��ת���ַ�
     *@return ת����ĳ���������
     */
    public static long parseLong(String str) {
        if (str != null && !"".equals(str)) {
            str = str.trim();
            if (StringUtils.isNumeric(str)) {
                return Long.parseLong(str);
            }
        }
        return 0L;
    }

    /**
     *ȡ��HTTP�����е�ָ����ֵ���ַ����(��������ڻ�Ϊ�գ��򷵻ؿ��ַ�).
     *
     *@param req
     *           HTTP����
     *@param key
     *           �����ֵ
     *@return ȡ�õ��ַ����
     */
    public static String getStrFromRequest(HttpServletRequest req, String key) {
        String str = req.getParameter(key);
        if (str != null && !"".equals(str)) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return str.trim();
        }
        return "";
    }

    /**
     *ȡ��Session�е�ָ����ֵ���ַ����(��������ڻ�Ϊ�գ��򷵻ؿ��ַ�).
     *
     *@param req
     *           HTTP����
     *@param key
     *           �����ֵ
     *@return ȡ�õ��ַ����
     */
    public static String getStrFromSession(HttpServletRequest req, String key) {
        String str = (String) req.getSession().getAttribute(key);
        if (str != null && !"".equals(str)) {
            return str.trim();
        }
        return "";
    }

    /**
     *ȡ��Session�е�ָ����ֵ���ַ����(��������ڻ�Ϊ�գ��򷵻ؿ��ַ�).
     *
     *@param session
     *           session
     *@param key
     *           �����ֵ
     *@return ȡ�õ��ַ����
     */
    public static String getStrFromSession(HttpSession session, String key) {
        String str = (String) session.getAttribute(key);
        if (str != null && !"".equals(str)) {
            return str.trim();
        }
        return "";
    }

    /**
     *ȡ��HTTP�����е�ָ����ֵ�����Ͳ���.
     *
     *@param req
     *           HTTP����
     *@param key
     *           �����ֵ
     *@return ȡ�õ����Ͳ���
     */
    public static int getIntFromRequest(HttpServletRequest req, String key) {
        String str = req.getParameter(key);
        return Utils.parseInt(str);
    }

    /**
     *ȡ��HTTP�����е�ָ����ֵ�ĳ����Ͳ���.
     *
     *@param req
     *           HTTP����
     *@param key
     *           �����ֵ
     *@return ȡ�õĳ����Ͳ���
     */
    public static long getLongFromRequest(HttpServletRequest req, String key) {
        String str = req.getParameter(key);
        return Utils.parseLong(str);
    }

    /**
     *ȡ��HTTP�����е�ָ����ֵ�ĸ����Ͳ���.
     *
     *@param req
     *           HTTP����
     *@param key
     *           �����ֵ
     *@return ȡ�õĸ����Ͳ���
     */
    public static float getFloatFromRequest(HttpServletRequest req, String key) {
        String str = req.getParameter(key);
        return Float.parseFloat(str);
    }

    /**
     *ȡ��HTTP�����е�ָ����ֵ�ĸ����Ͳ���.
     *
     *@param req
     *           HTTP����
     *@param key
     *           �����ֵ
     *@return ȡ�õĸ����Ͳ���
     */
    public static double getDoubleFromRequest(HttpServletRequest req, String key) {
        String str = req.getParameter(key);
        return Double.parseDouble(str);
    }

    /**
     *���ָ�ʽ.
     */
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
}

