package com.boot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boot.ManageApplication;
import com.boot.domain.Admin;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ManageApplication.class)
public class TestRepository {
	
	@Autowired
	private AdminRepository adRepos;
	
	@Test
	public void testAdminRepos() throws Exception {
		String adName = "admin";
		long a = 1l;
//		String id = adRepos.catchAdminId(adName);
		Admin ad = adRepos.findByAdminName(adName);
//		Admin ad = adRepos.findAdminId(Long.parseLong(id));
		System.out.println(new ObjectMapper().writeValueAsString(ad));
	}

}
