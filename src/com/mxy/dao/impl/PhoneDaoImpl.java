package com.mxy.dao.impl;

import org.springframework.stereotype.Repository;

import com.mxy.dao.PhoneDao;
import com.mxy.entity.Phone;
import com.mxy.entity.User;

@Repository("phoneDao")
public class PhoneDaoImpl extends BaseDaoImpl<Phone> implements PhoneDao {

	/* (non-Javadoc)
	 * @see com.mxy.dao.PhoneDao#delete(com.mxy.entity.User)
	 */
	@Override
	public void delete(User user) {
		String hql = "delete Phone where user = ?";
		this.getSession().createQuery(hql).setParameter(0, user).executeUpdate();
		
	}

	
}
