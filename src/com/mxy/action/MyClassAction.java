package com.mxy.action;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.mxy.entity.Message;
import com.mxy.entity.MyClass;
import com.mxy.entity.User;
import com.mxy.service.MessageService;
import com.mxy.service.MyClassService;

@Controller
public class MyClassAction extends BaseAction {

	private static final long serialVersionUID = 534923556987770958L;

	@Resource
	private MyClassService myClassService;
	@Resource
	private MessageService messageService;
	private MyClass myClass;
	private int class_id;
	private String content;
	
	//将用户踢出班级
	private int id;
	private int uid;
	private int cid;
	/**
	 * 创建班级
	 * @return
	 */
	public String create()
	{
		this.myClass.setCreateDate(new Date());
		this.myClass.setModifyDate(new Date());
		this.myClass.setUser((User)this.session.get("user"));
		Set<User> set = new HashSet<User>();
		set.add((User)this.session.get("user"));
		this.myClass.setUsers(set);
		this.myClassService.save(myClass);
		return "create";
	}
	
	/**
	 * 用户加入班级
	 * @return
	 */
	public String join()
	{
		Message m = new Message();
		m.setLook(false);
		m.setUser((User)this.session.get("user"));
		m.setMyClass(this.myClassService.get(this.class_id));
		m.setResult(0);
		m.setContent(content);
		this.messageService.save(m);
		return "join";
	}
	
	//进入班级界面
	public String myClass()
	{
		return "myClass";
	}
	
	//
	public String kickout()
	{
		if(uid == ((User)this.session.get("user")).getId())
		{
			this.myClassService.deleteUser(id, cid);
			return "kickout";
		}
		return "error";
	}
	
	//============================================================
	public MyClass getMyClass() {
		return myClass;
	}
	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
	}

	public List<MyClass> getClasses()
	{
		//return this.myClassService.getList("user",	(User)this.session.get("user"));
		//return ((User)this.session.get("user")).getClasses();
		return this.myClassService.get((User)this.session.get("user"));
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
}
