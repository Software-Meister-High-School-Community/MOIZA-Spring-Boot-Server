package com.moiza.moizaspringbootserver.feed.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.feed.error.FeedErrorCode;

public class BadFeedTypeException extends MoizaException {
    private BadFeedTypeException() {
        super(FeedErrorCode.BAD_FEED_TYPE);
    }

    public static final MoizaException EXCEPTION = new BadFeedTypeException();
}
