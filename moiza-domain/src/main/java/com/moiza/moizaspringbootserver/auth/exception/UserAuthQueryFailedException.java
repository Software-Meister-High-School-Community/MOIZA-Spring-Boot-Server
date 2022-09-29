package com.moiza.moizaspringbootserver.auth.exception;

import com.moiza.moizaspringbootserver.auth.error.AuthErrorCode;
import com.moiza.moizaspringbootserver.error.MoizaException;

public class UserAuthQueryFailedException extends MoizaException {
    private UserAuthQueryFailedException() {
        super(AuthErrorCode.USER_QUERY_FAILED);
    }

    public static final MoizaException EXCEPTION = new UserAuthQueryFailedException();
}
