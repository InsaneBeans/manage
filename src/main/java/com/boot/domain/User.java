package com.boot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户实体类。用户表的主键设置为id,自增整形变量，从1开始
 * 
 * @author kangkang
 */
@Entity
@Table(name = "u_user")
public class User {

	@Id
	@GeneratedValue
	private long id;// 主键自增
	/**
	 * 身份证号码18位活着15位
	 */
	private String uuid;
	/**
	 * 姓名
	 */
	private String uname; // 姓名
	/**
	 * 性别
	 */
	private String usex; // 性别
	/**
	 * 出生日期
	 */
	private String udate;
	/**
	 * 民族
	 */
	@OneToOne
	private Nation unation;
	/**
	 * 地址
	 */
	private String uaddress;
	/**
	 * 其他
	 */
	private String uextra;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUdate() {
		return udate;
	}

	public void setUdate(String udate) {
		this.udate = udate;
	}

	public Nation getUnation() {
		return unation;
	}

	public void setUnation(Nation unation) {
		this.unation = unation;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getUextra() {
		return uextra;
	}

	public void setUextra(String uextra) {
		this.uextra = uextra;
	}
}
