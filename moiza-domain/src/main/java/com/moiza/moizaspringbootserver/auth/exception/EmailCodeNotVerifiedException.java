package com.moiza.moizaspringbootserver.auth.exception;

import com.moiza.moizaspringbootserver.auth.error.AuthErrorCode;
import com.moiza.moizaspringbootserver.error.MoizaException;

public class EmailCodeNotVerifiedException extends MoizaException {

	private EmailCodeNotVerifiedException() {
		super(AuthErrorCode.EMAIL_CODE_NOT_VERIFIED);
	}

	public static final EmailCodeNotVerifiedException EXCEPTION = new EmailCodeNotVerifiedException();
}

