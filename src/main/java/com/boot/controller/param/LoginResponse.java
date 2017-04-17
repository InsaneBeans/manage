package com.boot.controller.param;

/**
 * 登录结果反馈
 * 
 * @author kangkang
 *
 */
public class LoginResponse {
	/**
	 * 登录是否成功
	 */
	private boolean success;
	/**
	 * 反馈消息
	 */
	private String msg;
	
	public LoginResponse(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
