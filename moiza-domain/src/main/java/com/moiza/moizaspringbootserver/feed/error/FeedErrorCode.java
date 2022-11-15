package com.moiza.moizaspringbootserver.feed.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum FeedErrorCode implements ErrorProperty {
	BAD_FEED_TYPE(400, "No Such Feed Type"),
	FEED_NOT_FOUND(404, "feed is not found"),
	CATEGORY_NOT_FOUND(404, "Category is not found");

	private final int status;
	private final String message;
}
