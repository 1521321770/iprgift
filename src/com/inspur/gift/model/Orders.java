package com.inspur.gift.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "a_order")
public class Orders {

	@Id
	@GenericGenerator(name="systemUUId", strategy="uuid")
	@GeneratedValue(generator="systemUUId")
	private String id;

	/**
	 * 员工姓名
	 */
//	nullable属性表示该字段是否可以为null值，默认为true
	@Column(name="name", length=40, nullable=false)
	private String name;

	/**
	 * 员工邮箱
	 */
	@Column(name="mailbox", length=40, nullable=true)
	private String mailbox;

	/**
	 * 员工部门
	 */
	@Column(name="bumen", length=40, nullable=true)
	private String bumen;

	/**
	 * 员工二级部门
	 */
	@Column(name="bumen2", length=40, nullable=true)
	private String bumen2;

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

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public String getBumen() {
		return bumen;
	}

	public void setBumen(String bumen) {
		this.bumen = bumen;
	}

	public String getBumen2() {
		return bumen2;
	}

	public void setBumen2(String bumen2) {
		this.bumen2 = bumen2;
	}

}
