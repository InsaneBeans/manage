package com.boot.cotroller;

import com.boot.controller.param.LoginResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestLoginResponse {
	
	public static void main(String[] args) throws Exception {
		LoginResponse login = new LoginResponse(true, "成功!");
		System.out.println(new ObjectMapper().writeValueAsString(login));
	}

}
