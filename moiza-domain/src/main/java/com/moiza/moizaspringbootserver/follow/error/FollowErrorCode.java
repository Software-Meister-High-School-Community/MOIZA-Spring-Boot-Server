package com.moiza.moizaspringbootserver.follow.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum FollowErrorCode implements ErrorProperty {

	FOLLOW_NOT_FOUND(404, "follow is not found");

	private final int status;
	private final String message;
}
