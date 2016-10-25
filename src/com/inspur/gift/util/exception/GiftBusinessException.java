package com.inspur.gift.util.exception;

public class GiftBusinessException extends Exception{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private String msgCode = null;

		private String msg = null;

		public GiftBusinessException(String msgCode, String msg, Throwable cause)
		{
			super(msg, cause);
			this.msgCode = msgCode;
			this.msg = msg;
		}

		public GiftBusinessException(String msgCode, Throwable cause)
		{
			super(cause.getMessage(), cause);
			this.msgCode = msgCode;
			this.msg = cause.getMessage();
		}

		public GiftBusinessException(String msgCode, String msg)
		{
			super(msg);
			this.msgCode = msgCode;
			this.msg = msg;
		}

		public GiftBusinessException(String msgCode)
		{
			super(msgCode);
			this.msgCode = msgCode;
		}

		public String getMessage()
		{
			return this.msg;
		}

		public String getMessageCode()
		{
			return this.msgCode;
		}
}
