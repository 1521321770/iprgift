package com.inspur.gift.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.inspur.gift.model.Gift;

public class GiftBody extends BodyBean<Gift>{

	private String searchType;

	private String placeId;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	/**
	 * 获取待删除礼物的id集合
	 * @return
	 */
	public List<String> getIds(){
		List<Gift> list = getList();
		if (list != null && list.size() > 0) {
			List<String> ids = new ArrayList<String>();
			for (Gift gift : list) {
				ids.add(gift.getId());
			}
			return ids;
		} else {
			return null;
		}
	}

	public String getNames(){
		List<Gift> list = getList();
		if (list != null && list.size() > 0) {
			String names = "";
			for (Gift gift : list) {
				names += gift.getName() + "&";
			}
			return StringUtils.substring(names, 0, names.length() - 1);
		} else {
			return null;
		}
	}
}
