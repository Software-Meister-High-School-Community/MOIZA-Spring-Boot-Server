package com.moiza.moizaspringbootserver.auth.exception;

import com.moiza.moizaspringbootserver.auth.error.AuthErrorCode;
import com.moiza.moizaspringbootserver.error.MoizaException;

public class UserAlredayExistException extends MoizaException {
    private UserAlredayExistException() {
        super(AuthErrorCode.USER_ALREADY_EXISTS);
    }

    public static UserAlredayExistException EXCEPTION = new UserAlredayExistException();
}
