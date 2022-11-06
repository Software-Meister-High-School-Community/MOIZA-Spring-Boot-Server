package com.moiza.moizaspringbootserver.comment;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Aggregate
public class CommentAttachmentFile {

	private final UUID id;
	private final String attachmentFileUrl;
	private final UUID commentId;
}
