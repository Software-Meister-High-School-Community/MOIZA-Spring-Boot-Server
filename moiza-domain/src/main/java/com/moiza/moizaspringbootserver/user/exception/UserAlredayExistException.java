package com.moiza.moizaspringbootserver.user.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.user.error.UserErrorCode;

public class UserAlredayExistException extends MoizaException {
    private UserAlredayExistException() {
        super(UserErrorCode.USER_ALREADY_EXISTS);
    }

    public static final UserAlredayExistException EXCEPTION = new UserAlredayExistException();
}
