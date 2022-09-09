package com.moiza.moizaspringbootserver.domain.notice.mapper;

import com.moiza.moizaspringbootserver.domain.notice.domain.NoticeEntity;
import com.moiza.moizaspringbootserver.notice.Notice;
import org.springframework.stereotype.Component;

@Component
public class NoticeMapperImpl implements NoticeMapper{

    @Override
    public NoticeEntity noticeDomainToEntity(Notice notice) {
        return NoticeEntity.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .updatedAt(notice.getUpdatedAt())
                .isPinned(notice.isPinned())
                .build();
    }

    @Override
    public Notice noticeEntityToDomain(NoticeEntity noticeEntity) {
        return Notice.builder()
                .id(noticeEntity.getId())
                .title(noticeEntity.getTitle())
                .content(noticeEntity.getContent())
                .updatedAt(noticeEntity.getUpdatedAt())
                .isPinned(noticeEntity.isPinned())
                .build();
    }
}
