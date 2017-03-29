package com.boot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.boot.domain.City;

/**
 * 城市查询接口
 * 
 * @author kangkang
 *
 */
@Transactional
public interface CityRepository extends CrudRepository<City, Long>{

	@Query("select c from City c where c.province = ?1")
	public Iterable<City> findCity(String provinceid);
}
