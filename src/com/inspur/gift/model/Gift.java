package com.inspur.gift.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "a_gift")
public class Gift {

	@Id
	@GenericGenerator(name="systemUUId", strategy="uuid")
	@GeneratedValue(generator="systemUUId")
	private String id;

	/**
	 * 礼物名称
	 */
	@Column(name="name", length=40, nullable=false)
	private String name;

	/**
	 * 操作人Id
	 */
	// nullable=true 默认为空值，可以为空
	@Column(name="createrId", length=40)
	private String createrId;

	/**
	 * 描述
	 */
	@Column(name="description", length=500)
	private String description;

	/**
	 * 图片位置
	 */
	@Column(name="imgUrl", length=500)
	private String imgUrl;

	/**
	 * 部门礼物时间
	 */
	@Column(name="createTime")
	private Date createTime;

	/**
	 * 礼物修改时间
	 */
	@Column(name="updateTime")
	private Date updateTime;

	/**
	 * 是否已删除，0：已删除；1：未删除
	 */
	@Column(name="flag", length=20)
	private String flag;

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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
