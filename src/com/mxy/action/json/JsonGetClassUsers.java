package com.mxy.action.json;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.mxy.entity.User;
import com.mxy.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class JsonGetClassUsers extends ActionSupport {
	
	@Resource
	private UserService userService;
	private List<User> list;
	private int id;
	
	@Override
	public String execute()
	{
		list = this.userService.getClassList(id);
		return this.SUCCESS;
	}

	public List<User> getList() {
		return list;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
