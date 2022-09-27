package com.moiza.moizaspringbootserver.domain.comment.mapper;

import com.moiza.moizaspringbootserver.comment.Comment;
import com.moiza.moizaspringbootserver.domain.comment.domain.CommentEntity;

public interface CommentMapper {

	CommentEntity commentDomainToEntity(Comment comment);

	Comment commentEntityToDomain(CommentEntity commentEntity);
}
