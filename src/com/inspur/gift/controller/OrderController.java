package com.inspur.gift.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspur.gift.bean.OrderBody;
import com.inspur.gift.model.GiftOrder;
import com.inspur.gift.service.OrderService;
import com.inspur.gift.util.OperationResult;
import com.inspur.gift.util.Params;
import com.inspur.gift.util.ResultCode;
import com.inspur.gift.util.Results;
import com.inspur.gift.util.exception.GiftBusinessException;

@Controller
@RequestMapping("/gift/order")
public class OrderController {

	/**
	 * 日志操作
	 */
	private static final Log LOGGER = LogFactory.getLog(GiftController.class);

	@Autowired
	private OrderService orderService;

	@ResponseBody
	@RequestMapping(value = "/action/add.do", method = RequestMethod.POST)
	public OperationResult add(HttpServletRequest request,
			@RequestParam(value = "name", required = true) String name,
    		@RequestParam(value = "mailbox") String mailbox,
    		@RequestParam(value = "bumen") String bumen,  		
    		@RequestParam(value = "gift") String gift,
    		@RequestParam(value = "place") String place,
    		@RequestParam(value = "address") String address,
			@RequestParam(value = "telephone") String telephone){
		try {
			if (Params.isNull(name, mailbox, bumen, gift, place)) {
				return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_ERROR.toString(), "参数错误");
			}
			GiftOrder order = new GiftOrder();
			order.setName(name);
			order.setMailbox(mailbox);
			order.setBumen(bumen);
			order.setPlace(place);
			order.setGift(gift);
			order.setAddress(address);
			order.setTelephone(telephone);
			order.setNum("1");
			OperationResult result = orderService.save(order);
			return result;
		} catch (GiftBusinessException e){
			LOGGER.error("添加生日礼物订单操作，业务处理失败");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_SAVE_GIFT_ORDER.toString(), null);
		} catch (Exception e) {
			LOGGER.error("添加生日礼物订单操作，出现异常");
			e.printStackTrace();
			return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
		}
	}

        @ResponseBody
	    @RequestMapping(value = "/action/delete.do", method = RequestMethod.POST)
	    public OperationResult delete(HttpServletRequest request,
	            @RequestBody OrderBody orderBody){
	        try {
	            List<String> ids = orderBody.getIds();
	            System.out.println(ids);
	            if (Params.isNull(ids)) {
	                return Results.oprResult(false, ResultCode.ERROR_GIFT_PARAMETER_NULL.toString(), null);
	            }
	            OperationResult result = orderService.delete(ids);
	            return result;
	        } catch (GiftBusinessException e){
	            LOGGER.error("添加生日礼物订单操作，业务处理失败");
	            e.printStackTrace();
	            return Results.oprResult(false, ResultCode.ERROR_GIFT_SAVE_GIFT_ORDER.toString(), null);
	        } catch (Exception e) {
	            LOGGER.error("添加生日礼物订单操作，出现异常");
	            e.printStackTrace();
	            return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
	        }
	    }

	@ResponseBody
    @RequestMapping(value = "/action/list.do", method = RequestMethod.POST)
    public OperationResult list(HttpServletRequest request,
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "dir", defaultValue = "asc", required = false) String dir,
            @RequestParam(value = "field", defaultValue = "name", required = false) String field){
        try {
            OperationResult result = orderService.search();
            return result;
        } catch (GiftBusinessException e){
            LOGGER.error("添加生日礼物订单操作，业务处理失败");
            e.printStackTrace();
            return Results.oprResult(false, ResultCode.ERROR_GIFT_ORDER_SEARCH.toString(), null);
        } catch (Exception e) {
            LOGGER.error("添加生日礼物订单操作，出现异常");
            e.printStackTrace();
            return Results.oprResult(false, ResultCode.ERROR_GIFT_UNKNOW_ERROR.toString(), null);
        }
    }
}
