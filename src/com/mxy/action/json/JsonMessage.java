package com.mxy.action.json;

import java.util.List;

import javax.annotation.Resource;

import com.mxy.action.BaseAction;
import com.mxy.entity.Message;
import com.mxy.entity.User;
import com.mxy.service.MessageService;

public class JsonMessage extends BaseAction {
	
	@Resource
	private MessageService messageService;
	
	/**
	 * ���� 1�����ҵ����� 2���� ��������
	 */
	private int type;
	/**
	 * ���ص�Message����
	 */
	private List<Message> list;
	
	@Override
	public String execute()
	{
		list = this.messageService.getListByType(((User)this.session.get("user")), type);
		return this.SUCCESS;
	}
	
	//=========================================
	
	public List<Message> getList() {
		return list;
	}

	public void setType(int type) {
		this.type = type;
	}
}
