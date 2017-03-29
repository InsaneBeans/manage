package com.boot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.boot.domain.User;

@Transactional
public interface UserRepository extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{

	//查找当前修改用户
	@Query("select u from User u where u.uuid = ?1")
	public User findUser(String uuid);
}
