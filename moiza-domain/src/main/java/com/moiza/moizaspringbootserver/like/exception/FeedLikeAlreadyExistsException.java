package com.moiza.moizaspringbootserver.like.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.like.error.FeedLikeErrorCode;

public class FeedLikeAlreadyExistsException extends MoizaException {

    private FeedLikeAlreadyExistsException() {
        super(FeedLikeErrorCode.FEED_LIKE_ALREADY_EXISTS);
    }

    public static final MoizaException EXCEPTION = new FeedLikeAlreadyExistsException();
}
