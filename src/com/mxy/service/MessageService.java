package com.mxy.service;

import java.util.List;

import com.mxy.entity.Message;
import com.mxy.entity.User;

public interface MessageService extends BaseService<Message> {
	
	/**
	 * �����û�����Ҫ�����ͷ��ض�Ӧ��Message����
	 * @param user
	 * @param type
	 * @return
	 */
	public List<Message> getListByType(User user,int type);
}
