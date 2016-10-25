package com.inspur.gift.servlet;

/**
 * 常量定义类.
 * @author gao.fei
 */
public final class Consts {
    /**
     * 默认构造函数.
     */
    private Consts() {
    }

    // ////////////////////////公用常量//////////////////////////
    /**
     * Key值常量.
     */
    public static final String KEY_RESULT = "result", KEY_DATA = "data", KEY_TOTAL = "total";
    /**
     * 结果key值常量.
     */
    public static final String RESULT_SUCCESS = "success", RESULT_FAILED = "failed";
    /**
     * 用户登录相关常量.
     */
    public static final String KEY_LANGUAGE = "language", KEY_TOKEN = "token", KEY_ORG_ID = "orgId",
            KEY_USER_ID = "userId", KEY_USER_NAME = "userName", KEY_ROLE_ID = "roleId", KEY_ROLE_TYPE = "roleType",
            KEY_OPE_LIST = "opeList", KEY_IS_LDAP = "isLdap", KEY_DOMAIN_ID = "domainId",
            KEY_DOMAIN_NAME = "domainName", KEY_REMOTE_HOST_IP = "remoteHostIp", KEY_REMOTE_PORT = "remotePort",
            KEY_REMOTE_ADDR = "remoteAddr", KEY_REMOTE_USER = "remoteUser", KEY_WARN_DAYS = "warnDays";
}
