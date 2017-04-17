package com.boot.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.controller.param.LoginResponse;
import com.boot.domain.Admin;
import com.boot.repository.AdminRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @category 管理员登录实现类
 */
@RestController
public class AdminController {

	@Autowired
	private AdminRepository adrepository;

	/**
	 * 管理员登录Http接口
	 */
	@RequestMapping("/login")
	public void adminLogin(@RequestBody Admin admin, HttpServletResponse response, HttpSession session)
			throws IOException {

		LoginResponse resInfo = null;
		Admin resAd = adrepository.findByAdminName(admin.getAdName());
		if (resAd == null) {
			resInfo = new LoginResponse(false, "不存在此管理员！");
		} else {
			if (!resAd.getAdPsw().equals(admin.getAdPsw())) {
				resInfo = new LoginResponse(false, "密码错误！");
			} else {
				session.setAttribute("adminid", resAd.getAdName());
				resInfo = new LoginResponse(false, "登录成功！");
			}
		}
		jsonResponse(resInfo, response);
	}

	/**
	 * 响应json数据封装
	 */
	public void jsonResponse(LoginResponse json, HttpServletResponse response) {
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
