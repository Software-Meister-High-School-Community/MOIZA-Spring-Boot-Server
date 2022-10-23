package com.moiza.moizaspringbootserver.auth.exception;

import com.moiza.moizaspringbootserver.auth.error.AuthErrorCode;
import com.moiza.moizaspringbootserver.error.MoizaException;

public class InvalidPasswordException extends MoizaException {

    public static final MoizaException EXCEPTION =
            new InvalidPasswordException();
    private InvalidPasswordException() {
        super(AuthErrorCode.INVALID_PASSWORD);
    }
}
