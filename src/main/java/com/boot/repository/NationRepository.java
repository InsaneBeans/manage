package com.boot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.boot.domain.Nation;

/**
 * 民族查询接口
 * 
 * @author kangkang
 *
 */
public interface NationRepository extends PagingAndSortingRepository<Nation, Long> {

}
