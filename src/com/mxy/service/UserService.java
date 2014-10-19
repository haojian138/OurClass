package com.mxy.service;

import java.util.List;

import com.mxy.entity.User;

public interface UserService extends BaseService<User> {

	/**
	 * 验证用户名密码是否正确
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean check(String email,String password);
	
	/**
	 * 根据班级的名称查询所有用户
	 * @param id
	 * @return
	 */
	public List<User> getClassList(int id);
}
