package com.moiza.moizaspringbootserver.auth.exception;

import com.moiza.moizaspringbootserver.auth.error.AuthErrorCode;
import com.moiza.moizaspringbootserver.error.MoizaException;

public class InvalidRoleException extends MoizaException {

    public static final MoizaException EXCEPTION =
            new InvalidRoleException();

    private InvalidRoleException() {
        super(AuthErrorCode.INVALID_ROLE);
    }
}
