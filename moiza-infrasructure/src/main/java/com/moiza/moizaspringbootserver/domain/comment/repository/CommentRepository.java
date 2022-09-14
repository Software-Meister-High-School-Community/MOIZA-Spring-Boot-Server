package com.moiza.moizaspringbootserver.domain.comment.repository;

import com.moiza.moizaspringbootserver.domain.comment.CommentEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentEntity, UUID> {

}
