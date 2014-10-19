package com.mxy.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * �༶��Ϣ��
 * 
 * @author ������
 * @date�� ���ڣ�2012-9-16 ʱ�䣺����9:44:59
 * @version 1.0
 */
@Entity
public class MyClass extends BaseEntity implements Serializable{

	// �༶���ڵ�ʡ
	private String province;
	// �༶���ڵĳ���
	private String city;
	// �༶���ڵ���
	private String county;
	// ѧУ����
	private String school;
	// �༶����
	private String name;
	//�༶����
	private String description;
	// �༶�Ĵ�����
	private User user;
	// �༶������ѧ��
	private Set<User> users;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
