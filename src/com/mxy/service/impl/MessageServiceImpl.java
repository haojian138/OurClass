package com.mxy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mxy.dao.MessageDao;
import com.mxy.dao.MyClassDao;
import com.mxy.entity.Message;
import com.mxy.entity.MyClass;
import com.mxy.entity.User;
import com.mxy.service.MessageService;
@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {

	@Resource
	private MessageDao messageDao;
	@Resource
	private MyClassDao myClassDao;
	@Resource
	public void setBaseDao(MessageDao messageDao) {
		super.setBaseDao(messageDao);
	}
	/* (non-Javadoc)
	 * @see com.mxy.service.MessageService#getListByType(com.mxy.entity.User, int)
	 */
	@Override
	public List<Message> getListByType(User user, int type) {
		List<Message> list = new ArrayList<Message>();
		if(type == 1)//返回我的申请 未处理的
		{
			list = this.messageDao.getListNotLook(user);
		}
		else//返回待我处理的申请
		{
			List<MyClass> classList = this.myClassDao.getList("user", user);
			for(MyClass mc :classList)
			{
				list.addAll(this.messageDao.getList("myClass", mc));
			}
		}
		return list;
	}
	
	
}
