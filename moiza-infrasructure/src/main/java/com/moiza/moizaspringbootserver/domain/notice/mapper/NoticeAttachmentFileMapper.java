package com.moiza.moizaspringbootserver.domain.notice.mapper;


import com.moiza.moizaspringbootserver.domain.notice.domain.NoticeAttachmentFileEntity;
import com.moiza.moizaspringbootserver.notice.NoticeAttachmentFile;

public  interface NoticeAttachmentFileMapper {

    NoticeAttachmentFileEntity noticeAttachmentFileDomainToEntity(NoticeAttachmentFile noticeAttachment);

    NoticeAttachmentFile noticeAttachmentFileEntityToDomain(NoticeAttachmentFileEntity noticeAttachmentFile);

}
