package com.mxy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mxy.dao.UserDao;
import com.mxy.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	/* (non-Javadoc)
	 * @see com.mxy.dao.UserDao#getClassList(int)
	 */
	@Override
	public List<User> getClassList(int id) {
		String hql = "select u from User u join u.classes c where c.id="+id+" ";
		return this.getSession().createQuery(hql).list();
	}

	
}
