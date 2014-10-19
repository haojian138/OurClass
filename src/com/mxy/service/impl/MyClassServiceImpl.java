package com.mxy.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mxy.dao.MyClassDao;
import com.mxy.dao.UserDao;
import com.mxy.entity.MyClass;
import com.mxy.entity.User;
import com.mxy.service.MyClassService;

@Service("myClassService")
public class MyClassServiceImpl extends BaseServiceImpl<MyClass> implements
		MyClassService {

	@Resource
	private MyClassDao myClassDao;
	@Resource
	private UserDao userDao;
	@Resource
	public void setBaseDao(MyClassDao myClassDao) {
		super.setBaseDao(myClassDao);
	}
	/* (non-Javadoc)
	 * @see com.mxy.service.MyClassService#getListLike(java.lang.String, java.lang.String)
	 */
	@Override
	public List<MyClass> getListLike(String pro, String value) {

		return this.myClassDao.getListLike(pro, value);
	}
	/* (non-Javadoc)
	 * @see com.mxy.service.MyClassService#kickoutUser(int, int)
	 */
	@Override
	public void deleteUser(int id, int cid) {
		User u = this.userDao.get(id);
		MyClass mc = this.myClassDao.get(cid);
		Set<User> set = mc.getUsers();
		System.out.println(set.size());
		set.remove(u);
		System.out.println(set.size());
		mc.setUsers(set);
		this.myClassDao.update(mc);
		
	}
	/* (non-Javadoc)
	 * @see com.mxy.service.MyClassService#get(com.mxy.entity.User)
	 */
	@Override
	public List<MyClass> get(User user) {
		
		return this.myClassDao.get(user);
	}
	
	
	
}
