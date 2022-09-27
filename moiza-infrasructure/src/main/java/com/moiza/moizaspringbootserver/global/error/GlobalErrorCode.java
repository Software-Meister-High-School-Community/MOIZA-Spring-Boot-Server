package com.moiza.moizaspringbootserver.global.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode implements ErrorProperty {
    INVALID_TOKEN(401, "Invalid token"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}
