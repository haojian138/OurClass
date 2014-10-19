package com.mxy.action.json;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.mxy.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class JsonCheck extends ActionSupport{

	@Resource
	private UserService userService;
	
	private String email;
	private boolean result;
	@Override
	public String execute()
	{
		this.result = this.userService.isExist("email", email);
		return this.SUCCESS;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isResult() {
		return result;
	}
}
