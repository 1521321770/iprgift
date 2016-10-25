package com.inspur.gift.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 部门信息表
 * @author gzc
 *
 */
@Entity
@Table(name = "a_bumen")
public class Bumen {

	@Id
	@GenericGenerator(name="systemUUId", strategy="uuid")
	@GeneratedValue(generator="systemUUId")
	private String id;

	/**
	 * 部门名称
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
	 * 部门添加时间
	 */
	@Column(name="createTime")
	private Date createTime;

	/**
	 * 部门名称修改时间
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
