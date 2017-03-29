package com.boot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 管理员实体类，包含管理员ID和密码两个参数。
 * 
 * @author kangkang
 *
 */
@Entity
@Table(name = "u_admin")
public class Admin {

	/**
	 * 自增主键
	 */
	@Id
	@GeneratedValue
	private long id;
	/**
	 * 管理员名称
	 */
	@JsonProperty("adname")
	private String adName;
	/**
	 * 管理员密码
	 */
	@JsonProperty("adpsw")
	private String adPsw;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdPsw() {
		return adPsw;
	}

	public void setAdPsw(String adPsw) {
		this.adPsw = adPsw;
	}

}
