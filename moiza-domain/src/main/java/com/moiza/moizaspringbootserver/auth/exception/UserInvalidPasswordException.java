package com.moiza.moizaspringbootserver.auth.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.user.error.UserErrorCode;

public class UserInvalidPasswordException extends MoizaException {

	private UserInvalidPasswordException() {
		super(UserErrorCode.USER_INVALID_PASSWORD);
	}

	public static final MoizaException EXCEPTION = new UserInvalidPasswordException();

}
