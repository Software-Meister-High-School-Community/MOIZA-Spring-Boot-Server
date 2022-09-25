package com.moiza.moizaspringbootserver.feed.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum FeedErrorCode implements ErrorProperty {

	FEED_NOT_FOUND(404, "feed is not found");

	private final int status;
	private final String message;
}
