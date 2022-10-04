package com.moiza.moizaspringbootserver.report.user.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserReportErrorCode implements ErrorProperty {

    USER_REPORT_NOT_FOUND(404, "User Report Not Found"),

    FEED_REPORT_ALREADY_EXISTS(409, "Feed Report Already Exists");

    private final int status;
    private final String message;
}
