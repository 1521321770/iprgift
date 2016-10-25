package com.inspur.gift.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.inspur.gift.model.Workplace;

public class WorkplaceBody extends BodyBean<Workplace>{

	/**
	 * 获取待删除部门的id集合
	 * @return
	 */
	public List<String> getIds(){
		List<Workplace> list = getList();
		if (list != null && list.size() > 0) {
			List<String> ids = new ArrayList<String>();
			for (Workplace wPlace : list) {
				ids.add(wPlace.getId());
			}
			return ids;
		} else {
			return null;
		}
	}

	public String getNames(){
		List<Workplace> list = getList();
		if (list != null && list.size() > 0) {
			String names = "";
			for (Workplace wPlace : list) {
				names += wPlace.getName() + "&";
			}
			return StringUtils.substring(names, 0, names.length() - 1);
		} else {
			return null;
		}
	}
}
