package com.inspur.gift.util.exception;

public class GiftDBException extends Exception{

	private static final long serialVersionUID = 1L;

	public GiftDBException(String msg, Throwable cause)
	{
		super(msg, cause);
	}

	public GiftDBException(String msg)
	{
		super(msg);
	}
}
