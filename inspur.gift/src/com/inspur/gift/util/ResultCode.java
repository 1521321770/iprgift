package com.inspur.gift.util;

/**
 * 操作结果码
 * @author gzc
 */
public enum ResultCode {

	/**
	 * 添加部门操作失败
	 */
	ERROR_GIFT_ADD_BUMEN(20100),

	/**
	 * 部门已经存在
	 */
	ERROR_GIFT_BUMEN_EXIST(20101),

	/**
	 * 部门不存在
	 */
	ERROR_GIFT_BUMEN_NO_EXIST(20102),

	/**
	 * 删除部门失败
	 */
	ERROR_GIFT_DELETE_BUME(20103),

	/**
	 * 修改部门失败
	 */
	ERROR_GIFT_MODIFY_BUME(20104),

	/**
	 * 查询部门失败
	 */
	ERROR_GIFT_SEARCH_BUME(20105),

	/**
	 * 添加工作地操作失败
	 */
	ERROR_GIFT_ADD_WORKPLACE(20110),

	/**
	 * 工作地已经存在
	 */
	ERROR_GIFT_WORKPLACE_EXIST(20111),

	/**
	 * 工作地不存在
	 */
	ERROR_GIFT_WORKPLACE_NO_EXIST(20112),

	/**
	 * 删除工作地失败
	 */
	ERROR_GIFT_DELETE_WORKPLACE(20113),

	/**
	 * 修改工作地失败
	 */
	ERROR_GIFT_MODIFY_WORKPLACE(20114),

	/**
	 * 查询工作地失败
	 */
	ERROR_GIFT_SEARCH_WORKPLACE(20115),

	/**
	 * 添加礼物操作失败
	 */
	ERROR_GIFT_ADD_GIFT(20120),

	/**
	 * 礼物已经存在
	 */
	ERROR_GIFT_GIFT_EXIST(20121),

	/**
	 * 礼物不存在
	 */
	ERROR_GIFT_GIFT_NO_EXIST(20122),

	/**
	 * 删除礼物失败
	 */
	ERROR_GIFT_DELETE_GIFT(20123),

	/**
	 * 修改礼物失败
	 */
	ERROR_GIFT_MODIFY_GIFT(20124),

	/**
	 * 查询礼物失败
	 */
	ERROR_GIFT_SEARCH_GIFT(20125),

	/**
	 * 查询礼物失败
	 */
	ERROR_GIFT_SAVE_GIFT_ORDER(20130),

	/**
	 * 员工不存在
	 */
	ERROR_GIFT_EMPLOYEE_NO_EXIST(20140),

    /**
     * 查看礼物订单失败
     */
    ERROR_GIFT_ORDER_SEARCH(20150),

	/**
	 * 上传图片出现问题
	 */
	ERROR_GIFT_PATH_ERROR(29996),

	/**
	 * 参数错误
	 */
	ERROR_GIFT_PARAMETER_ERROR(29997),

	/**
	 * 出现未知错误
	 */
	ERROR_GIFT_UNKNOW_ERROR(29998),

	/**
	 * 参数不能为空
	 */
	ERROR_GIFT_PARAMETER_NULL(29999);

	private int value;

	private ResultCode(int value){
		this.value = value;
	}

	public String toString(){
		return this.value + "";
	}
}
