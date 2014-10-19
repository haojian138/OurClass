package com.mxy.dao;

import java.util.List;

import com.mxy.entity.Message;
import com.mxy.entity.MyClass;
import com.mxy.entity.User;

public interface MessageDao extends BaseDao<Message> {

	/**
	 * ��ȡ���û�δ�����δ�Ķ���Message
	 * @param user
	 * @return
	 */
	public List<Message> getListNotLook(User user);
	
	/**
	 * ����ĳ���༶δ���������
	 * @param myClass
	 * @return
	 */
	public List<Message> getListClassNotDeal(MyClass myClass);
	
}
