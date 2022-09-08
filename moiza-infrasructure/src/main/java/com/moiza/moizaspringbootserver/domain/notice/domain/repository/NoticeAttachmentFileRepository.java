package com.moiza.moizaspringbootserver.domain.notice.domain.repository;

import com.moiza.moizaspringbootserver.domain.notice.domain.NoticeAttachmentFileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoticeAttachmentFileRepository extends CrudRepository<NoticeAttachmentFileEntity, UUID> {
}
