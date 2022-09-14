package com.moiza.moizaspringbootserver.comment.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CommentErrorCode implements ErrorProperty {

	COMMENT_NOT_FOUND(404, "코멘트를 찾을 수 없음");

	private final int status;
	private final String message;
}

