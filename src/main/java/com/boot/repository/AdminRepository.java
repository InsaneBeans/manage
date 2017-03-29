package com.boot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.boot.domain.Admin;

@Transactional
public interface AdminRepository extends PagingAndSortingRepository<Admin,String>{
	
	@Query("select id from Admin ad where ad.ad_id = ?1")
	public String catchAdminId(String adid);

}
