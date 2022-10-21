package com.moiza.moizaspringbootserver.like.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.like.error.FeedLikeErrorCode;

public class FeedLikeNotFoundException extends MoizaException {
    private FeedLikeNotFoundException() {
        super(FeedLikeErrorCode.FEED_LIKE_NOT_FOUND);
    }

    public static final MoizaException EXCEPTION = new FeedLikeNotFoundException();
}
