package com.moiza.moizaspringbootserver.auth.exception;

import com.moiza.moizaspringbootserver.auth.error.AuthErrorCode;
import com.moiza.moizaspringbootserver.error.MoizaException;

public class AuthCodeAlreadyVerifiedException extends MoizaException {

    private AuthCodeAlreadyVerifiedException() {
        super(AuthErrorCode.AUTH_CODE_ALREADY_VERIFIED);
    }

    public static final AuthCodeAlreadyVerifiedException EXCEPTION = new AuthCodeAlreadyVerifiedException();
}
