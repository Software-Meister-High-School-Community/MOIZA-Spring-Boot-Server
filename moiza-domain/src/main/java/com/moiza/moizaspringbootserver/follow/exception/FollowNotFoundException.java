package com.moiza.moizaspringbootserver.follow.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.follow.error.FollowErrorCode;

public class FollowNotFoundException extends MoizaException {

	private FollowNotFoundException() {
		super(FollowErrorCode.FOLLOW_NOT_FOUND);
	}

	public static final FollowNotFoundException EXCEPTION = new FollowNotFoundException();
}