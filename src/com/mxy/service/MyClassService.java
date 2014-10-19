package com.mxy.service;

import java.util.List;

import com.mxy.entity.MyClass;
import com.mxy.entity.User;


public interface MyClassService extends BaseService<MyClass> {

	public List<MyClass> getListLike(String pro,String value);
	/**
	 * ���û��Ӱ༶���߳�
	 * @param id
	 * @param cid
	 */
	public void deleteUser(int id,int cid);
	
	public List<MyClass> get(User user);
}
