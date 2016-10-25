package com.inspur.gift.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.inspur.gift.model.Bumen;

/**
 * 批量删除部门操作
 * @author gzc
 *
 */
public class BumenBody extends BodyBean<Bumen>{

	/**
	 * 获取待删除部门的id集合
	 * @return
	 */
	public List<String> getIds(){
		List<Bumen> list = getList();
		if (list != null && list.size() > 0) {
			List<String> ids = new ArrayList<String>();
			for (Bumen bumen : list) {
				ids.add(bumen.getId());
			}
			return ids;
		} else {
			return null;
		}
	}

	public String getNames(){
		List<Bumen> list = getList();
		if (list != null && list.size() > 0) {
			String names = "";
			for (Bumen bumen : list) {
				names += bumen.getName() + "&";
			}
			return StringUtils.substring(names, 0, names.length() - 1);
		} else {
			return null;
		}
	}
}
