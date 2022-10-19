package com.moiza.moizaspringbootserver.like.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum FeedLikeErrorCode implements ErrorProperty {
    FEED_LIKE_NOT_FOUND(404, "Feed Like Not Found"),
    FEED_LIKE_ALREADY_EXISTS(409, "Feed Like Already Exists")
    ;

    private final int status;

    public final String message;
}