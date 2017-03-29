package com.boot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 省份实体类
 * 
 * @author kangkang
 */
@Entity
@Table(name = "u_province")
public class Province {

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue
	private long id;

	/**
	 * 省份id
	 */
	private String provId;
	/**
	 * 省份名称
	 */
	private String provName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProvId() {
		return provId;
	}

	public void setProvId(String provId) {
		this.provId = provId;
	}

	public String getProvName() {
		return provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

}
