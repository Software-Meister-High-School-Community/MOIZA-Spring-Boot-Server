package com.moiza.moizaspringbootserver.comment;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Aggregate
public class CommentAttatchmentFile {

	private final UUID id;
	private final String attatchmentFileUrl;
	private final UUID commentId;
}
