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
 * �û���Ϣ
 * 
 * @author ������
 * @date�� ���ڣ�2012-9-16 ʱ�䣺����9:35:19
 * @version 1.0
 */
@Entity
public class User extends BaseEntity implements Serializable{

	// �û�ע���email
	private String email;
	// �û�����ʵ����
	private String name;
	// �û�����
	private String password;
	// �û�����İ༶
	private Set<MyClass> classes;
	//�û����ֻ���
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
