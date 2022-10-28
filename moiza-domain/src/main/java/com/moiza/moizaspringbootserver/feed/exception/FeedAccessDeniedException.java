package com.moiza.moizaspringbootserver.feed.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.feed.error.FeedErrorCode;

public class FeedAccessDeniedException extends MoizaException {
    private FeedAccessDeniedException() {
        super(FeedErrorCode.FEED_ACCESS_DENIED);
    }

    public static final MoizaException EXCEPTION = new FeedAccessDeniedException();
}
