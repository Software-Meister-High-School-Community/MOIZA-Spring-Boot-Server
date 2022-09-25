package com.moiza.moizaspringbootserver.auth.exception;

import com.moiza.moizaspringbootserver.auth.error.AuthErrorCode;
import com.moiza.moizaspringbootserver.error.MoizaException;

public class EmailCodeNotFoundException extends MoizaException {

    public EmailCodeNotFoundException() {
        super(AuthErrorCode.EMAIL_CODE_NOT_FOUND);
    }

    public static final EmailCodeNotFoundException EXCEPTION = new EmailCodeNotFoundException();
}
