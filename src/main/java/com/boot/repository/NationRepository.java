package com.boot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.boot.domain.Nation;

public interface NationRepository extends PagingAndSortingRepository<Nation,String> {

}
