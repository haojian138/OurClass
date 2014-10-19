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
 * 用户查找班级
 * 查找的结果是非自己创建的班级
 * @author 孟祥月
 * @date： 日期：2012-9-24 时间：下午6:54:03
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
				if(mc.getId() == uc.getId())//如果相等说明这个班级已经加入过了
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
