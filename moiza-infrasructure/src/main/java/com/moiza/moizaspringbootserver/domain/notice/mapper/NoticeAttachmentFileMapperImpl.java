package com.moiza.moizaspringbootserver.domain.notice.mapper;

import com.moiza.moizaspringbootserver.domain.notice.domain.NoticeAttachmentFileEntity;
import com.moiza.moizaspringbootserver.notice.NoticeAttachmentFile;
import org.springframework.stereotype.Component;

@Component
public class NoticeAttachmentFileMapperImpl implements NoticeAttachmentFileMapper{

    @Override
    public NoticeAttachmentFileEntity noticeAttachmentFileDomainToEntity(NoticeAttachmentFile noticeAttachment) {
        return NoticeAttachmentFileEntity.builder()
                .id(noticeAttachment.getNoticeId())
                .attachmentFileUrl(noticeAttachment.getAttachmentFileUrl())
                .build();
    }

    @Override
    public NoticeAttachmentFile noticeAttachmentFileEntityToDomain(NoticeAttachmentFileEntity noticeAttachmentFile) {
        return NoticeAttachmentFile.builder()
                .id(noticeAttachmentFile.getId())
                .attachmentFileUrl(noticeAttachmentFile.getAttachmentFileUrl())
                .build();
    }
}
