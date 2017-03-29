package com.boot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.boot.domain.Admin;

/**
 * 管理员查询接口
 * 
 * @author kangkang
 *
 */
@Transactional
public interface AdminRepository extends PagingAndSortingRepository<Admin, Long> {

	@Query("select id from Admin ad where ad.adName = ?1")
	public String catchAdminId(String adName);

	public Admin findByAdName(String adName);

}
