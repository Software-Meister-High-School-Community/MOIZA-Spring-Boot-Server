package com.moiza.moizaspringbootserver.user.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserErrorCode implements ErrorProperty {

	USER_NOT_FOUND(404, "유저를 찾을 수 없음"),

	USER_AlREADY_EXISTS(409, "유저가 이미 존재합니다");

	private final int status;
	private final String message;
}
