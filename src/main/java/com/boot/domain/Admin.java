package com.boot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @category 管理员实体类，包含管理员ID和密码两个参数。
 *
 */
@Entity
@Table(name = "u_admin")
public class Admin {
	
	@Id
	@GeneratedValue
	private String id;
	private String ad_id;
	private String ad_psw;

	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setAd_id(String ad_id){
		this.ad_id = ad_id;
	}
	
	public String getAd_id(){
		return ad_id;
	}
	
    public void setAd_psw(String ad_psw){
		this.ad_psw = ad_psw;
	}
	
	public String getAd_psw(){
		return ad_psw;
	}
}
