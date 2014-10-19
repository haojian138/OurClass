package com.mxy.dao;

import com.mxy.entity.Phone;
import com.mxy.entity.User;

public interface PhoneDao extends BaseDao<Phone> {
	
	/**
	 * 删除某个用户所有的手机号
	 * @param user
	 */
	public void delete(User user);

}
