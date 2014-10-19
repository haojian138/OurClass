package com.mxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mxy.dao.UserDao;
import com.mxy.entity.User;
import com.mxy.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {
	
	@Resource
	private UserDao userDao;
	@Resource
	public void setBaseDao(UserDao userDao) {
		super.setBaseDao(userDao);
	}

	/* (non-Javadoc)
	 * @see com.mxy.service.UserService#check(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean check(String email, String password) {
		User user = this.get("email", email);
		if(password.equals(user.getPassword()))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.mxy.service.UserService#getClassList(int)
	 */
	@Override
	public List<User> getClassList(int id) {
		return this.userDao.getClassList(id);
	}
	
	
	
}
