package com.moiza.moizaspringbootserver.domain.feed.mapper;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedAttachmentFileEntity;
import com.moiza.moizaspringbootserver.feed.FeedAttachmentFile;
import org.springframework.stereotype.Component;

@Component
public class FeedAttachmentFileMapperImpl implements FeedAttachmentFileMapper {
    @Override
    public FeedAttachmentFile feedAttachmentFileEntityToDomain(FeedAttachmentFileEntity entity) {
        return FeedAttachmentFile.builder()
                .id(entity.getId())
                .attachmentFileUrl(entity.getAttachmentFileUrl())
                .build();
    }

    @Override
    public FeedAttachmentFileEntity feedAttachmentDomainToEntity(FeedAttachmentFile attachment) {
        return FeedAttachmentFileEntity.builder()
                .id(attachment.getId())
                .attachmentFileUrl(attachment.getAttachmentFileUrl())
                .build();
    }
}
