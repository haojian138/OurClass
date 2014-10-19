package com.mxy.dao;

import java.util.List;

import com.mxy.entity.Message;
import com.mxy.entity.MyClass;
import com.mxy.entity.User;

public interface MessageDao extends BaseDao<Message> {

	/**
	 * 获取该用户未处理后未阅读的Message
	 * @param user
	 * @return
	 */
	public List<Message> getListNotLook(User user);
	
	/**
	 * 返回某个班级未处理的申请
	 * @param myClass
	 * @return
	 */
	public List<Message> getListClassNotDeal(MyClass myClass);
	
}
