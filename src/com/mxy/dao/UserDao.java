package com.mxy.dao;

import java.util.List;

import com.mxy.entity.User;

public interface UserDao extends BaseDao<User> {

	/**
	 * ���ݰ༶�����Ʋ�ѯ�����û�
	 * @param id
	 * @return
	 */
	public List<User> getClassList(int id);
}
