package com.moiza.moizaspringbootserver.user.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.user.error.UserErrorCode;

public class UserAlreadyExistsException extends MoizaException {

	private UserAlreadyExistsException() {
		super(UserErrorCode.USER_AlREADY_EXISTS);
	}

	public static final MoizaException EXCEPTION = new UserAlreadyExistsException();
}

