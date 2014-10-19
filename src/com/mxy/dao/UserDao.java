package com.mxy.dao;

import java.util.List;

import com.mxy.entity.User;

public interface UserDao extends BaseDao<User> {

	/**
	 * 根据班级的名称查询所有用户
	 * @param id
	 * @return
	 */
	public List<User> getClassList(int id);
}
