package com.moiza.moizaspringbootserver.domain.comment.domain.repository;

import com.moiza.moizaspringbootserver.domain.comment.domain.CommentAttatchmentFileEntity;
import java.util.UUID;

import com.moiza.moizaspringbootserver.domain.comment.domain.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentAttachmentFileRepository extends CrudRepository<CommentAttatchmentFileEntity, UUID> {

    void deleteByCommentEntity(CommentEntity commentEntity);

}
