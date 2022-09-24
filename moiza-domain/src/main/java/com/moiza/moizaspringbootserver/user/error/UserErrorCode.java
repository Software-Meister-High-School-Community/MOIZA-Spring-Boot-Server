package com.moiza.moizaspringbootserver.user.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserErrorCode implements ErrorProperty {

	USER_NOT_FOUND(404, "유저를 찾을 수 없음"),
	USER_ALREADY_EXISTS(409, "이미 해당 ID를 사용하는 유저가 존재합니다.");

	private final int status;
	private final String message;
}
