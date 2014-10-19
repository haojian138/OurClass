package com.mxy.dao;

import java.util.List;

import com.mxy.entity.MyClass;
import com.mxy.entity.User;

public interface MyClassDao extends BaseDao<MyClass> {

	public List<MyClass> getListLike(String pro,String value);
	
	/**
	 * 查找某个用户加入的班级
	 * @param user
	 * @return
	 */
	public List<MyClass> get(User user);
}
