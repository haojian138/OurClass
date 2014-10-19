package com.mxy.dao;

import java.io.Serializable;
import java.util.List;


import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T extends Serializable> {

	/**
	 * ����ID��ȡʵ�����.
	 * 
	 * @param id
	 *            ��¼ID
	 * @return ʵ�����
	 */
	public T get(Integer id);

	/**
	 * ����ID��ȡʵ�����.
	 * 
	 * @param id
	 *            ��¼ID
	 * @return ʵ�����
	 */
	public T load(Integer id);
	
	/**
	 * ����ID�����ȡʵ����󼯺�.
	 * 
	 * @param ids
	 *            ID��������
	 * 
	 * @return ʵ����󼯺�
	 */
	public List<T> get(Integer[] ids);
	
	/**
	 * ����������������ֵ��ȡʵ�����.
	 * 
	 * @param propertyName
	 *            ��������
	 * @param value
	 *            ����ֵ
	 * @return ʵ�����
	 */
	public T get(String propertyName, Object value);
	
	/**
	 * ����������������ֵ��ȡʵ����󼯺�.
	 * 
	 * @param propertyName
	 *            ��������
	 * @param value
	 *            ����ֵ
	 * @return ʵ����󼯺�
	 */
	public List<T> getList(String propertyName, Object value);

	/**
	 * ��ȡ����ʵ����󼯺�.
	 * 
	 * @return ʵ����󼯺�
	 */
	public List<T> getAll();
	
	/**
	 * ��ȡ����ʵ���������.
	 * 
	 * @return ʵ���������
	 */
	public Long getTotalCount();

	/**
	 * �������������޸�ǰ������ֵ�ж������ݿ����Ƿ�Ψһ(�����޸ĵ�ֵ��ԭ��ֵ�����ֱ�ӷ���true).
	 * 
	 * @param propertyName
	 *            ��������
	 * @param oldValue
	 *            �޸�ǰ������ֵ
	 * @param oldValue
	 *            �޸ĺ������ֵ
	 * @return boolean
	 */
	public boolean isUnique(String propertyName, Object oldValue, Object newValue);
	
	/**
	 * �����������ж������Ƿ��Ѵ���.
	 * 
	 * @param propertyName
	 *            ��������
	 * @param value
	 *            ֵ
	 * @return boolean
	 */
	public boolean isExist(String propertyName, Object value);

	/**
	 * ����ʵ�����.
	 * 
	 * @param entity
	 *            ����
	 * @return ID
	 */
	public Integer save(T entity);

	/**
	 * ����ʵ�����.
	 * 
	 * @param entity
	 *            ����
	 */
	public void update(T entity);
	
	/**
	 * ɾ��ʵ�����.
	 * 
	 * @param entity
	 *            ����
	 * @return
	 */
	public void delete(T entity);

	/**
	 * ����IDɾ��ʵ�����.
	 * 
	 * @param id
	 *            ��¼ID
	 */
	public void delete(Integer id);

	/**
	 * ����ID����ɾ��ʵ�����.
	 * 
	 * @param ids
	 *            ID����
	 */
	public void delete(Integer[] ids);

	/**
	 * ˢ��session.
	 * 
	 */
	public void flush();

	/**
	 * ���Session.
	 * 
	 */
	public void clear();
	
	/**
	 * ���ĳһ����.
	 * 
	 * @param object
	 *            ��Ҫ����Ķ���
	 */
	public void evict(Object object);

}
