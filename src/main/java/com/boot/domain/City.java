package com.boot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 城市实体类
 * 
 * @author kangkang
 */
@Entity
@Table(name = "u_city")
public class City {

	/**
	 * 主键id
	 */
	@Id
	@GeneratedValue
	private long id;

	/**
	 * 城市id
	 */
	private String cityId;
	/**
	 * 城市名称
	 */
	private String cityName;
	/**
	 * 城市所在的省份
	 */
	@ManyToOne
	private Province province;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

}
