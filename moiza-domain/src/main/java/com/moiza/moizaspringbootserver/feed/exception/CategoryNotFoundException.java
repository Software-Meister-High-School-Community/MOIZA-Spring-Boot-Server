package com.moiza.moizaspringbootserver.feed.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.feed.error.FeedErrorCode;

public class CategoryNotFoundException extends MoizaException {

    private CategoryNotFoundException() {
        super(FeedErrorCode.CATEGORY_NOT_FOUND);
    }

    public static final MoizaException EXCEPTION = new CategoryNotFoundException();
}