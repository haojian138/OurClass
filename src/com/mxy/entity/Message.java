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
 * �û�����Ϣ �����û��������༶�Ļ�����Ϣ
 * 
 * @author ������
 * @date�� ���ڣ�2012-9-16 ʱ�䣺����10:37:43
 * @version 1.0
 */
@Entity
public class Message extends BaseEntity {

	// �û��������༶��ʱ���������Ϣ
	private String content;
	// �������༶���û���ͬʱҲ�Ǵ�������Message���û�
	private User user;
	// �û��������İ༶
	private MyClass myClass;
	// �û������� 0��ʾδ���� 1��ʾͬ�� -1��ʾ��ͬ��
	private int result;
	// ��Ϣ����� ��ʶ�û��Ƿ��Ѿ��鿴
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
