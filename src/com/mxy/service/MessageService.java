package com.mxy.service;

import java.util.List;

import com.mxy.entity.Message;
import com.mxy.entity.User;

public interface MessageService extends BaseService<Message> {
	
	/**
	 * 根据用户所需要的类型返回对应的Message集合
	 * @param user
	 * @param type
	 * @return
	 */
	public List<Message> getListByType(User user,int type);
}
