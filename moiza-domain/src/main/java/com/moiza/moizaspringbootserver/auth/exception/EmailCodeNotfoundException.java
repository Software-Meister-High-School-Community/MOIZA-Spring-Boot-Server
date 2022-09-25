package com.moiza.moizaspringbootserver.auth.exception;

import com.moiza.moizaspringbootserver.auth.error.AuthErrorCode;
import com.moiza.moizaspringbootserver.error.MoizaException;

public class EmailCodeNotfoundException extends MoizaException {

	private EmailCodeNotfoundException() {
		super(AuthErrorCode.EMAIL_CODE_NOT_FOUND);
	}

	public static final EmailCodeNotfoundException EXCEPTION = new EmailCodeNotfoundException();
}
