package com.mxy.service;

import com.mxy.entity.Phone;
import com.mxy.entity.User;

public interface PhoneService extends BaseService<Phone> {
	
	/**
	 * 删除用户的所有手机号
	 */
	public void delete(User user);
}
