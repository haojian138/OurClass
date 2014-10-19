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
	 * 类型 1代表我的申请 2代表 申请审批
	 */
	private int type;
	/**
	 * 返回的Message对象
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
