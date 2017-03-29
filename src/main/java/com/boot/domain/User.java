package com.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @category 用户实体类
 * @version 用户表的主键设置为id,自增整形变量，从1开始
 */
@Entity
@Table(name = "u_user")

public class User {
	
	@Id
	@GeneratedValue
	private String id;//主键自增
	
	@Column(name="uuid")
	private String uuid;     //身份证号码(19位)
	
	@Column(name="uname")
	private String uname;   //姓名
	
	@Column(name="usex")
	private String usex;    //性别
	
	@Column(name="udate")
	private String udate;   //出生日期
	
	@Column(name="uminzu")
	private String uminzu;  //民族
	
	@Column(name="uarea")
	private String uarea;
	
	@Column(name="uextra")
	private String uextra;
	
	public String getId(){
		return id;
	}
	public void setId( String id){
		this.id = id;
	}
	
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	
	public String getUuid(){
		return uuid;
	}
	
	public void setUname(String name){
		this.uname = name;
	}
	
	public String getUname(){
		return uname;
	}

	public void setUsex(String usex){
		this.usex = usex;
	}
	
	public String getUsex(){
		return usex;
	}

	public void setUminzu(String uminzu){
		this.uminzu = uminzu;
	}
	
	public String getUminzu(){
		return uminzu;
	}

	public void setUdate(String udate){
		this.udate = udate;
	}
	
	public String getUdate(){
		return udate;
	}
	
	public void setUextra(String uextra){
		this.uextra = uextra;
	}
	
	public String getUextra(){
		return uextra;
	}

	public String getUarea() {
		return uarea;
	}
	
	public void setUarea(String uarea) {
		this.uarea = uarea;
	}
}
