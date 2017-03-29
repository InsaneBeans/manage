package com.boot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.boot.domain.Province;

@Transactional
public interface ProvinceRepository extends CrudRepository<Province,String>{

	@Query("select p from Province p where p.province = ?1")
	public Province catchProvinceId(String provincename);
}
