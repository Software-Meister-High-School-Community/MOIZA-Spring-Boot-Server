package com.moiza.moizaspringbootserver.domain.notice.mapper;

import com.moiza.moizaspringbootserver.domain.notice.domain.NoticeEntity;
import com.moiza.moizaspringbootserver.notice.Notice;

public interface NoticeMapper {

    NoticeEntity noticeDomainToEntity(Notice notice);
    Notice noticeEntityToDomain(NoticeEntity notice);

}
