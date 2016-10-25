package com.inspur.gift.bean;

import java.util.Date;

public class GiftInfo {

	private String id;

	/**
	 * 礼物名称
	 */
	private String name;

	/**
	 * 操作人Id
	 */
	private String createrId;

	private String createrName;
	/**
	 * 描述
	 */
	private String description;

	/**
	 * 图片位置
	 */
	private String imgUrl;

	/**
	 * 部门礼物时间
	 */
	private Date createTime;

	/**
	 * 礼物修改时间
	 */
	private Date updateTime;

	/**
	 * 工作地
	 */
	private String places;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

	public String getPlaces() {
		return places;
	}

	public void setPlaces(String places) {
		this.places = places;
	}
}
