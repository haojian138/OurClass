package com.mxy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mxy.dao.MyClassDao;
import com.mxy.entity.MyClass;
import com.mxy.entity.User;

@Repository("myClassDao")
public class MyClassDaoImpl extends BaseDaoImpl<MyClass> implements MyClassDao {

	/* (non-Javadoc)
	 * @see com.mxy.dao.MyClassDao#getListLike(java.lang.String, java.lang.String)
	 */
	@Override
	public List<MyClass> getListLike(String pro, String value) {
		String hql = "from MyClass where "+pro+" like '%"+value+"%'";
		return this.getSession().createQuery(hql).list();
	}

	/* (non-Javadoc)
	 * @see com.mxy.dao.MyClassDao#get(com.mxy.entity.User)
	 */
	@Override
	public List<MyClass> get(User user) {
		String hql = "select mc from MyClass mc join mc.users u where u.id="+user.getId();
		return this.getSession().createQuery(hql).list();
	}

	
	
}
