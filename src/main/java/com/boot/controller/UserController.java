package com.boot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.domain.City;
import com.boot.domain.Nation;
import com.boot.domain.Province;
import com.boot.domain.User;
import com.boot.repository.CityRepository;
import com.boot.repository.NationRepository;
import com.boot.repository.ProvinceRepository;
import com.boot.repository.UserRepository;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;

/**
 * @category 用户操作类,实现增删查改以及下拉框的实现
 */
@RestController
public class UserController {

	@Autowired
	private UserRepository userrepository;

	@Autowired
	private NationRepository nationrepository;
	
	@Autowired
	private ProvinceRepository provincerepository;
	
	@Autowired
	private CityRepository cityrepository;
	
	/**
	 * @category 默认进入管理员登录界面
	 */
	@RequestMapping("")
	public void inDex(HttpServletResponse response) throws IOException {
		response.sendRedirect("/index.html");
	}

	/**
	 * @category 下拉民族列表实现方法
	 */
	@RequestMapping("/user/national")
	public Iterable<Nation> nationList(){
		return nationrepository.findAll();
	}
	
	
	/**
	 * @category 下拉省份列表实现方法
	 */
	@RequestMapping("/user/province")
	public Iterable<Province> provinceList(){
		return provincerepository.findAll();
	}
	
	/**
	 * @category 下拉城市列表实现方法
	 */
	@RequestMapping("/user/city")
	public Iterable<City> cityList(String provincename){
			String provinceid = provincerepository.catchProvinceId(provincename).getProvId();
			return cityrepository.findCity(provinceid);
	}
	
	/**
	 * @category 添加用户方法
	 */
	@RequestMapping("/user/add")
	public void addUser(User user, HttpServletResponse response) {

		String json;
		String existid = user.getUuid();
		User existuser = userrepository.findUser(existid);
		if (existuser == null) {
			userrepository.save(user);
			json = "{\"success\":true,\"msg\":\"添加成功！\"}";
		} else if (userrepository.exists(existuser.getId())) {
			json = "{\"success\":false,\"msg\":\"身份证已经存在！请更换重试！\"}";
		} else {

			json = "{\"failure\":true,\"msg\":\"系统错误！\"}";
		}
		jsonResponse(json, response);

	}
	
	/**
	 * @category 修改用户方法
	 */
	@RequestMapping("/user/modify")
	public void modifyUser(User user, HttpServletResponse response) {

		String json;
		User mdfuser = userrepository.findUser(user.getUuid());
		if(mdfuser==null){
			json = "{\"success\":false,\"msg\":\"检测到这是新的身份证!请选择添加此用户\"}";
		} else {
			mdfuser.setUuid(user.getUuid());
			mdfuser.setUname(user.getUname());
			mdfuser.setUnation(user.getUnation());
			mdfuser.setUsex(user.getUsex());
			mdfuser.setUdate(user.getUdate());
			mdfuser.setUextra(user.getUextra());
			mdfuser.setUaddress(user.getUaddress());
			userrepository.save(mdfuser);
			json = "{\"success\":true,\"msg\":\"修改成功!\"}";
	   }
	   jsonResponse(json, response);
	}

	/**
	 * @category 删除用户方法
	 */
	@RequestMapping("/user/delete")
	public void deleteUser(String[] uuid, HttpServletResponse response) {

		int length = uuid.length;
		List<User> userlist = new ArrayList<User>();
		for (int i = 0; i < length; i++) {
			userlist.add(userrepository.findUser(uuid[i]));
		}
		userrepository.deleteInBatch(userlist);
		String json = "{\"success\":true\"}";
		jsonResponse(json, response);
	}

	/**
	 * @category 向前台返回json数据方法
	 */
	public static void jsonResponse(String json, HttpServletResponse response) {
		try {
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @category 数据库中所有的用户信息,分页列表显示方法
	 */
	@RequestMapping("/user/list")
	public Page<User> pageUser(Integer page, Integer limit, String sort,
			                   HttpServletRequest request) throws JSONException {
		
		if (sort == null) {
			Pageable pageable = new PageRequest(page - 1, limit);
			return userrepository.findAll(pageable);
		} else {
			JSONArray jsonArray = JSONArray.fromObject(sort);
			String property = jsonArray.getJSONObject(0).getString("property");
			String direction = jsonArray.getJSONObject(0).getString("direction");
			Order order;
			if (direction.equals("DESC")) {
				order = new Order(Direction.DESC, property);
			} else {
				order = new Order(Direction.ASC, property);
			}
			Sort sorter = new Sort(order);
			Pageable pageable = new PageRequest(page - 1, limit, sorter);
			return userrepository.findAll(pageable);
		}
	}

	/**
	 * @category 用户搜索方法
	 */
	@RequestMapping("/user/search")
	public Iterable<User> searchUser(User user,HttpServletResponse response) {
//		String id = user.getId();
		return userrepository.findAll();
	}
	
}