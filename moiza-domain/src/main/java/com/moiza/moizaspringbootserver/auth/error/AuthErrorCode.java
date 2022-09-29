package com.moiza.moizaspringbootserver.auth.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AuthErrorCode implements ErrorProperty {

    EMAIL_CODE_NOT_VERIFIED(401, "Email Code Not Verified"),
    EMAIL_CODE_NOT_FOUND(404, "Email Code Not Found"),
    AUTH_CODE_ALREADY_VERIFIED(409, "Auth Code Already Verified"),

    USER_QUERY_FAILED(409, "user query failed."),
    INVALID_PASSWORD(401,"Invalid Password"),
  	REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found");

	private final int status;
	private final String message;
}
