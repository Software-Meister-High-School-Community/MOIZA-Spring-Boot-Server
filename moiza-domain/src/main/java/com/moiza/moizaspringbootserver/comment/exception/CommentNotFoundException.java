package com.moiza.moizaspringbootserver.comment.exception;

import com.moiza.moizaspringbootserver.comment.error.CommentErrorCode;
import com.moiza.moizaspringbootserver.error.MoizaException;

public class CommentNotFoundException extends MoizaException {

	private CommentNotFoundException() {
		super(CommentErrorCode.COMMENT_NOT_FOUND);
	}

	public static final CommentNotFoundException EXCEPTION = new CommentNotFoundException();
}