package com.boot.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.domain.Admin;
import com.boot.repository.AdminRepository;

/**
 * @category 管理员登录实现类
 */
@RestController
public class AdminController {

	@Autowired
	private AdminRepository adrepository;
	
	/**
	 * @category 管理员登录实现方法
	 */
	@RequestMapping("/login")
	public void adminLogin(@RequestBody Admin admin,HttpServletResponse response,HttpSession session) throws IOException{
		
			String json = null;
			String id = adrepository.catchAdminId(admin.getAdName());
			if(id==null){
	            json = "{\"success\":false,\"msg\":\"不存在此管理员！\"}";
			} else {
				 Admin judgeadmin = adrepository.findByAdName(id);
				 if (!judgeadmin.getAdPsw().equals(admin.getAdPsw())){
					json = "{\"success\":false,\"msg\":\"密码错误！\"}";
				} else {
					session.setAttribute("adminid",judgeadmin.getAdName());
					json = "{\"success\":true,\"msg\":\"登录成功！\"}";
				}
			}
		  jsonResponse(json,response);
	}
	
	/**
	 * @category 响应json数据封装
	 */
	public void jsonResponse(String json, HttpServletResponse response) {
			try {
				response.getWriter().write(json);
				response.getWriter().flush();
				response.getWriter().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
