package com.inspur.gift.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "a_gift_order")
public class GiftOrder {

	@Id
	@GenericGenerator(name="systemUUId", strategy="uuid")
	@GeneratedValue(generator="systemUUId")
	private String id;

	/**
	 * 员工姓名
	 */
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

	@Column(name="gift", length=40, nullable=true)
	private String gift;

	@Column(name="place", length=40, nullable=true)
	private String place;

	@Column(name="address", length=40, nullable=true)
	private String address;

	@Column(name="telephone", length=40, nullable=true)
	private String telephone;

	@Column(name="num", length=40, nullable=true)
	private String num;

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

	public String getGift() {
		return gift;
	}

	public void setGift(String gift) {
		this.gift = gift;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
}
