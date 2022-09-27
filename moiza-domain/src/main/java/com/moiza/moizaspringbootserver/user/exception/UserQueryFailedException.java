package com.moiza.moizaspringbootserver.user.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.user.error.UserErrorCode;

public class UserQueryFailedException extends MoizaException {
    private UserQueryFailedException() {
        super(UserErrorCode.USER_QUERY_FAILED);
    }

    public static final UserQueryFailedException EXCEPTION = new UserQueryFailedException();
}
