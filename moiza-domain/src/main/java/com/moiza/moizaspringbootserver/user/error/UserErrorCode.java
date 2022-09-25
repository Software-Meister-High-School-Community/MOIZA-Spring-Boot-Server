package com.moiza.moizaspringbootserver.user.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserErrorCode implements ErrorProperty {

	USER_NOT_FOUND(404, "No such user."),
	USER_ALREADY_EXISTS(409, "User already exists.");

	private final int status;
	private final String message;
}
