package com.mxy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mxy.dao.MessageDao;
import com.mxy.entity.Message;
import com.mxy.entity.MyClass;
import com.mxy.entity.User;

@Repository("messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {

	/* (non-Javadoc)
	 * @see com.mxy.dao.MessageDao#getListNotDeal(com.mxy.entity.User)
	 */
	@Override
	public List<Message> getListNotLook(User user) {
		String hql = "from Message where user =? and look =?";
		return this.getSession().createQuery(hql).setParameter(0, user).setParameter(1, false).list();
	}

	/* (non-Javadoc)
	 * @see com.mxy.dao.MessageDao#getListClassNotDeal(com.mxy.entity.MyClass)
	 */
	@Override
	public List<Message> getListClassNotDeal(MyClass myClass) {
		String hql = "from Message where myClass=? and result='0'";
		return this.getSession().createQuery(hql).setParameter(0, myClass).list();
	}

	
}
