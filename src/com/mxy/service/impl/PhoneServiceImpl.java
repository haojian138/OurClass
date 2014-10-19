package com.mxy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mxy.dao.PhoneDao;
import com.mxy.entity.Phone;
import com.mxy.entity.User;
import com.mxy.service.PhoneService;

@Repository("phoneService")
public class PhoneServiceImpl extends BaseServiceImpl<Phone> implements
		PhoneService {
	@Resource
	private PhoneDao phoneDao;
	@Resource
	public void setBaseDao(PhoneDao phoneDao) {
		super.setBaseDao(phoneDao);
	}
	@Override
	public void delete(User user) {
		phoneDao.delete(user);
	}
	
}
