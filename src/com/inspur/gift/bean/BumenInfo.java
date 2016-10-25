package com.inspur.gift.bean;

import java.util.Date;

/**
 * 用于前端显示部门信息列表
 * @author gzc
 *
 */
public class BumenInfo {

	private String id;

	/**
	 * 部门名称
	 */
	private String name;

	/**
	 * 操作人Id
	 */
	private String createrId;

	/**
	 * 操作人姓名
	 */
	private String createrName;
	/**
	 * 部门添加时间
	 */
	private Date createTime;

	/**
	 * 部门名称修改时间
	 */
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
