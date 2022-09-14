package com.moiza.moizaspringbootserver.comment;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Aggregate
public class Comment {

	private final UUID id;
	private final String content;
	private final boolean isPinned;
	private final ZonedDateTime createAt;
	private final ZonedDateTime updatedAt;
	private final UUID userId;
	private final UUID feedId;
	private final UUID parentCommentId;
}
