package com.moiza.moizaspringbootserver.feed.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.feed.error.FeedErrorCode;

public class LocalFeedNotFoundException extends MoizaException {

    private LocalFeedNotFoundException() {
        super(FeedErrorCode.FEED_NOT_FOUND);
    }

    public static final MoizaException EXCEPTION = new LocalFeedNotFoundException();
}