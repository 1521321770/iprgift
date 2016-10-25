package com.inspur.gift.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "a_mapper")
public class Mapper {

	@Id
	@GenericGenerator(name="systemUUId", strategy="uuid")
	@GeneratedValue(generator="systemUUId")
	private String id;

	/**
	 * 主键
	 */
	@Column(name="pKey", length=40)
	private String pKey;

	/**
	 * 操作人Id
	 */
	// nullable=true 默认为空值，可以为空
	@Column(name="fKey", length=40)
	private String fKey;

	/**
	 * 部门添加时间
	 */
	@Column(name="type", length=10, nullable = false)
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpKey() {
		return pKey;
	}

	public void setpKey(String pKey) {
		this.pKey = pKey;
	}

	public String getfKey() {
		return fKey;
	}

	public void setfKey(String fKey) {
		this.fKey = fKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
