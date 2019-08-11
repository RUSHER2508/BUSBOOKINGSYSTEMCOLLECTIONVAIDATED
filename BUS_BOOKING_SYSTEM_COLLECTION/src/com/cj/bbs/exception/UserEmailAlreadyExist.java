package com.cj.bbs.exception;

public class UserEmailAlreadyExist extends  RuntimeException{

	public UserEmailAlreadyExist(String msg) {
		super(msg);
	}
}
