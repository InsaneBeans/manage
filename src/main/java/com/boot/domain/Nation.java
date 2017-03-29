package com.boot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *@category 民族实体类
 */
@Entity
@Table(name="nation")
public class Nation {
	
	@Id
	private String u_mzid;
	
	private String u_minzu;
	
	public String getU_mzid(){
		return u_mzid;
	}
	
	public String getU_minzu(){
		return u_minzu;
	}
	
	
	

}
