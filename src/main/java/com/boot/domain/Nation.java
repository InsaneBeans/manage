package com.boot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 民族实体类
 * 
 * @author kangkang
 */
@Entity
@Table(name = "u_nation")
public class Nation {

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue
	private long id;
	/**
	 * 民族id
	 */
	private String mingzuId;
	/**
	 * 民族名称
	 */
	private String minzuName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMingzuId() {
		return mingzuId;
	}

	public void setMingzuId(String mingzuId) {
		this.mingzuId = mingzuId;
	}

	public String getMinzuName() {
		return minzuName;
	}

	public void setMinzuName(String minzuName) {
		this.minzuName = minzuName;
	}

}
