package com.mxy.dao;

import com.mxy.entity.Phone;
import com.mxy.entity.User;

public interface PhoneDao extends BaseDao<Phone> {
	
	/**
	 * ɾ��ĳ���û����е��ֻ���
	 * @param user
	 */
	public void delete(User user);

}
