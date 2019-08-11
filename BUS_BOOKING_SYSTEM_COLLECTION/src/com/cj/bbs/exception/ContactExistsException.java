package com.cj.bbs.exception;

public class ContactExistsException extends RuntimeException{

	public ContactExistsException(String msg) {
		super(msg);
	}
}
