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
 * 用户的手机号 一个用户可以有多个手机号
 * 后期需要加入手机号的归属地信息
 * @author 孟祥月
 * @date： 日期：2012-9-16 时间：上午10:23:42
 * @version 1.0
 */
@Entity
public class Phone extends BaseEntity implements Serializable{

	// 用户的手机号
	private String phone;
	// 手机号的所有者
	private User user;

	@Column(nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
