package com.inspur.gift.bean;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 批量删除操作父类
 * @author gzc
 *
 */
public class BodyBean<T>{

	@SuppressWarnings("unchecked")
	Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	private List<T> list;

	private T newObj;

	private T oldObj;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T getNewObj() {
		return newObj;
	}

	public void setNewObj(T newObj) {
		this.newObj = newObj;
	}

	public T getOldObj() {
		return oldObj;
	}

	public void setOldObj(T oldObj) {
		this.oldObj = oldObj;
	}
}
