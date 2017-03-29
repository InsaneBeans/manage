package com.boot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.boot.domain.Province;

/**
 * 省份查询接口
 * 
 * @author kangkang
 *
 */
@Transactional
public interface ProvinceRepository extends CrudRepository<Province, Long>{

	@Query("select p from Province p where p.provName = ?1")
	public Province catchProvinceId(String provincename);
}
