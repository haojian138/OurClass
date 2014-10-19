package com.mxy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 用户的消息 包括用户请求加入班级的基本信息
 * 
 * @author 孟祥月
 * @date： 日期：2012-9-16 时间：上午10:37:43
 * @version 1.0
 */
@Entity
public class Message extends BaseEntity {

	// 用户请求加入班级的时候输入的信息
	private String content;
	// 请求加入班级的用户，同时也是创建此条Message的用户
	private User user;
	// 用户请求加入的班级
	private MyClass myClass;
	// 用户处理结果 0表示未处理 1表示同意 -1表示不同意
	private int result;
	// 消息处理后 标识用户是否已经查看
	private boolean look;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "myClassId")
	public MyClass getMyClass() {
		return myClass;
	}

	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public boolean isLook() {
		return look;
	}

	public void setLook(boolean look) {
		this.look = look;
	}

}
