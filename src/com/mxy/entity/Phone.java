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
 * �û����ֻ��� һ���û������ж���ֻ���
 * ������Ҫ�����ֻ��ŵĹ�������Ϣ
 * @author ������
 * @date�� ���ڣ�2012-9-16 ʱ�䣺����10:23:42
 * @version 1.0
 */
@Entity
public class Phone extends BaseEntity implements Serializable{

	// �û����ֻ���
	private String phone;
	// �ֻ��ŵ�������
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
