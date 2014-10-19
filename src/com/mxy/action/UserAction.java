package com.mxy.action;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.mxy.entity.Phone;
import com.mxy.entity.User;
import com.mxy.service.PhoneService;
import com.mxy.service.UserService;

@Controller
public class UserAction extends BaseAction {

	@Resource
	private UserService userService;
	@Resource
	private PhoneService phoneService;
	private User user;
	private String[] phones;
	//需要显示的用户的Id
	private int id;
	//从页面获得的uid
	private int uid;

	/**
	 * 用户登录
	 * @return
	 */
	public String login() {
		if(user.getEmail() == null || user.getPassword() == null)
			return "login_input";
		if(this.userService.check(user.getEmail(), user.getPassword()))
		{
			this.session.put("user", this.userService.get("email", user.getEmail()));
			return "login";
		}
		return "login_input";
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	public String register()
	{
		this.user.setCreateDate(new Date());
		this.user.setModifyDate(new Date());
		this.userService.save(user);
		this.session.put("user", this.userService.get("email", user.getEmail()));
		return "register";
	}
	
	/**
	 * 用户信息的修改
	 * @return
	 */
	public String modify()
	{
		User u = (User)this.session.get("user");
		Set<Phone> set = u.getPhones();
		this.phoneService.delete(u);
		set.clear();
		for(int i = 0;i<phones.length;i++)
		{
			if(phones[i] == null || "".equals(phones[i]))
				continue;
			Phone p = new Phone();
			p.setCreateDate(new Date());
			p.setModifyDate(new Date());
			p.setUser(u);
			p.setPhone(phones[i]);
			set.add(p);
		}
		u.setPhones(set);
		this.userService.update(u);
		return "modify";
	}
	
	public String  userInfo()
	{
		if(uid == ((User)this.session.get("user")).getId())
		{
			this.user = this.userService.get(id);
			return "userInfo";
		}
		return "error";
	}

	// =====================================================================
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setPhones(String[] phones) {
		this.phones = phones;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	
}
