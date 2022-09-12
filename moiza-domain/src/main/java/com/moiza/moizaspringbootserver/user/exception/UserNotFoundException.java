package com.moiza.moizaspringbootserver.user.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.user.error.UserErrorCode;

public class UserNotFoundException extends MoizaException {

	private UserNotFoundException() {
		super(UserErrorCode.USER_NOT_FOUND);
	}

	public static final UserNotFoundException EXCEPTION = new UserNotFoundException();
}
