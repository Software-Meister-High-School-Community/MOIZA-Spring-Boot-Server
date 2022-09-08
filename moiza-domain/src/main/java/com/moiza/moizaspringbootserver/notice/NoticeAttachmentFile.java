package com.moiza.moizaspringbootserver.notice;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class NoticeAttachmentFile {

    private final UUID id;
    private final String attachmentFileUrl;
    private final UUID noticeId;

}
