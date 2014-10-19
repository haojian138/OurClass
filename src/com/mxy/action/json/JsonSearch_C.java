package com.mxy.action.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import com.mxy.entity.MyClass;
import com.mxy.entity.User;
import com.mxy.service.MyClassService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * �û����Ұ༶
 * ���ҵĽ���Ƿ��Լ������İ༶
 * @author ������
 * @date�� ���ڣ�2012-9-24 ʱ�䣺����6:54:03
 * @version 1.0
 */
public class JsonSearch_C extends ActionSupport implements SessionAware{
	
	@Resource 
	private MyClassService myClassService;
	private Map<String,Object> session;
	private String search;
	private List<MyClass> list = new ArrayList<MyClass>();
	
	@Override
	public String execute()
	{
		List<MyClass> t = this.myClassService.getListLike("name", search);
		for(MyClass mc :t)
		{
			boolean flag = false;
			for(MyClass uc : ((User)this.session.get("user")).getClasses())
				if(mc.getId() == uc.getId())//������˵������༶�Ѿ��������
				{
					flag = true;
					break;
				}
			if(!flag)
				list.add(mc);
		}		
		return this.SUCCESS;
	}
	
	//===========================================================
	public List<MyClass> getList() {
		return list;
	}

	public void setList(List<MyClass> list) {
		this.list = list;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
