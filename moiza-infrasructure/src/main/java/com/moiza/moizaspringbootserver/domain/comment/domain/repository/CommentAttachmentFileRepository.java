package com.moiza.moizaspringbootserver.domain.comment.domain.repository;

import com.moiza.moizaspringbootserver.domain.comment.domain.CommentAttachmentFileEntity;
import java.util.UUID;

import com.moiza.moizaspringbootserver.domain.comment.domain.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentAttachmentFileRepository extends CrudRepository<CommentAttachmentFileEntity, UUID> {

    void deleteAllByCommentEntity(CommentEntity commentEntity);

}
