package com.mxy.service;

import java.util.List;

import com.mxy.entity.User;

public interface UserService extends BaseService<User> {

	/**
	 * ��֤�û��������Ƿ���ȷ
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean check(String email,String password);
	
	/**
	 * ���ݰ༶�����Ʋ�ѯ�����û�
	 * @param id
	 * @return
	 */
	public List<User> getClassList(int id);
}
