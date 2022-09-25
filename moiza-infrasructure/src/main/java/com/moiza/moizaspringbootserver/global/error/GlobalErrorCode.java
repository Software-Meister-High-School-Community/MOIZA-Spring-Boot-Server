package com.moiza.moizaspringbootserver.global.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode implements ErrorProperty {
    INVALID_TOKEN(401, "Invalid token");

    int status;
    String message;
}
