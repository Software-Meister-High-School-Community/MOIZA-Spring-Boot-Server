package com.moiza.moizaspringbootserver.global.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.global.error.GlobalErrorCode;

public class InvalidTokenException extends MoizaException {
    private InvalidTokenException() {
        super(GlobalErrorCode.INVALID_TOKEN);
    }

    public static final InvalidTokenException EXCEPTION = new InvalidTokenException();
}
