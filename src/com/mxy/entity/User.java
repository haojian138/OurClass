package com.mxy.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * 用户信息
 * 
 * @author 孟祥月
 * @date： 日期：2012-9-16 时间：上午9:35:19
 * @version 1.0
 */
@Entity
public class User extends BaseEntity implements Serializable{

	// 用户注册的email
	private String email;
	// 用户的真实姓名
	private String name;
	// 用户密码
	private String password;
	// 用户加入的班级
	private Set<MyClass> classes;
	//用户的手机号
	private Set<Phone> phones;

	@Column(nullable = false,unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(fetch = FetchType.EAGER,mappedBy = "users")
	public Set<MyClass> getClasses() {
		return classes;
	}

	public void setClasses(Set<MyClass> classes) {
		this.classes = classes;
	}

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy="user")
	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	
	
}
