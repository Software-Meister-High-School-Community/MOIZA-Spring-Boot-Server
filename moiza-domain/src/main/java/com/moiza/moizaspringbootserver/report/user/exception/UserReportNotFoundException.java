package com.moiza.moizaspringbootserver.report.user.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.user.error.UserErrorCode;

public class UserReportNotFoundException extends MoizaException {


    public static final MoizaException EXCEPTION =
            new UserReportNotFoundException();

    private UserReportNotFoundException() {
        super(UserErrorCode.USER_NOT_FOUND);
    }
}
