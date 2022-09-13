package com.moiza.moizaspringbootserver.feed;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class FeedAttachmentFile {

    private final UUID id;
    private final String attachmentFileUrl;
    private final UUID feedId;

}
