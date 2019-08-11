package com.cj.bbs.exception;

public class UserIdNotExistException extends RuntimeException {

	public UserIdNotExistException(String msg) {
		super(msg);
	}
}
