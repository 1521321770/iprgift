package com.inspur.gift.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.inspur.gift.model.GiftOrder;

/**
 * 批量删除生日礼物订单
 * @author gzc
 */
public class OrderBody extends BodyBean<GiftOrder>{

    /**
     * 获取待删除礼物订单的id集合
     * @return
     */
    public List<String> getIds(){
        List<GiftOrder> list = getList();
        if (list != null && list.size() > 0) {
            List<String> ids = new ArrayList<String>();
            for (GiftOrder giftOrder : list) {
                ids.add(giftOrder.getId());
            }
            return ids;
        } else {
            return null;
        }
    }

    public String getNames(){
        List<GiftOrder> list = getList();
        if (list != null && list.size() > 0) {
            String names = "";
            for (GiftOrder giftOrder : list) {
                names += giftOrder.getName() + "&";
            }
            return StringUtils.substring(names, 0, names.length() - 1);
        } else {
            return null;
        }
    }
}
