package com.moiza.moizaspringbootserver.domain.comment.domain.repository;

import com.moiza.moizaspringbootserver.domain.comment.domain.CommentAttatchmentFileEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentAttatchmentRepository extends CrudRepository<CommentAttatchmentFileEntity, UUID> {

}
