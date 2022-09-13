package com.moiza.moizaspringbootserver.domain.feed.mapper;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedAttachmentFileEntity;
import com.moiza.moizaspringbootserver.feed.FeedAttachmentFile;

public interface FeedAttachmentFileMapper {
    FeedAttachmentFile feedAttachmentFileEntityToDomain(FeedAttachmentFileEntity entity);
    FeedAttachmentFileEntity feedAttachmentDomainToEntity(FeedAttachmentFile attachment);
}
