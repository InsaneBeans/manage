package com.boot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *@category 城市实体类
 */
@Entity
@Table(name="cities")
public class City {
	
	@Id
	@GeneratedValue
	private String id;
	
	private String cityid;
	
	private String city;
	
	private String provinceid;

	public String getId(){
		return id;
	}
	
	public void setID(String id){
		this.id = id;
	}
	
	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

}
