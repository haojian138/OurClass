package com.mxy.service;

import com.mxy.entity.Phone;
import com.mxy.entity.User;

public interface PhoneService extends BaseService<Phone> {
	
	/**
	 * ɾ���û��������ֻ���
	 */
	public void delete(User user);
}
