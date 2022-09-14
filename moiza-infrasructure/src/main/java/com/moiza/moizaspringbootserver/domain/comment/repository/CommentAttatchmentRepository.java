package com.moiza.moizaspringbootserver.domain.comment.repository;

import com.moiza.moizaspringbootserver.domain.comment.CommentAttatchmentFileEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface CommentAttatchmentRepository extends CrudRepository<CommentAttatchmentFileEntity, UUID> {

}
