package com.inspur.gift.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 员工信息表
 * @author gzc
 */
@Entity
@Table(name = "a_employee")
public class Employee {

	@Id
	@GenericGenerator(name="systemUUId", strategy="uuid")
	@GeneratedValue(generator="systemUUId")
	private String id;

	/**
	 * 员工编号(eg:LCBJ0005).
	 */
	@Column(name="employeeId", length=40, nullable=true)
	private String employeeId;

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

	/**
	 * 员工性别
	 */
	@Column(name="sex", length=40, nullable=true)
	private String sex;

	/**
	 * 员工工作地
	 */
	@Column(name="place", length=40, nullable=true)
	private String place;

	/**
	 * 员工出生日期
	 */
	@Column(name="birthday", length=40, nullable=true)
	private String birthday;

	/**
	 * 员工出生日期
	 */
	@Column(name="mouth", length=40, nullable=true)
	private String mouth;

	/**
	 * 员工岗位结构
	 */
	@Column(name="job", length=20, nullable=true)
	private String job;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMouth() {
		return mouth;
	}

	public void setMouth(String mouth) {
		this.mouth = mouth;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
