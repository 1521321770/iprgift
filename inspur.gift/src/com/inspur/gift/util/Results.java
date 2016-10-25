package com.inspur.gift.util;


/**
 * 返回操作结果
 * @author gzc
 *
 */
public class Results {

	public static OperationResult oprResult(boolean flag, String msgCode, Object resData){
		OperationResult result = new OperationResult();
		result.setFlag(flag);
		result.setMsgCode(msgCode);
		result.setResData(resData);
		return result;
	}

	public static OperationResult oprResult(OperationResult result){
		return result;
	}

	public static OperationResult result(boolean flag, String msgCode, Object resData){
		OperationResult result = new OperationResult();
		result.setFlag(flag);
		result.setMsgCode(msgCode);
		result.setResData(resData);
		return result;
	}

	public static OperationResult result(boolean flag, String msgCode){
		OperationResult result = new OperationResult();
		result.setFlag(flag);
		result.setMsgCode(msgCode);
		return result;
	}

	public static OperationResult result(boolean flag){
		OperationResult result = new OperationResult();
		result.setMsgCode(null);
		result.setFlag(flag);
		result.setResData(null);
		return result;
	}
}
