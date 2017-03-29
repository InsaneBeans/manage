package com.boot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.boot.domain.City;

@Transactional
public interface CityRepository extends CrudRepository<City,String>{

	@Query("select c from City c where c.provinceid = ?1")
	public Iterable<City> findCity(String provinceid);
}
