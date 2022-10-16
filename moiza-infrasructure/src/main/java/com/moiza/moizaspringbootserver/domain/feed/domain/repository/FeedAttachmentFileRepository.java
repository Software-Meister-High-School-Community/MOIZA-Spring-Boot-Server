package com.moiza.moizaspringbootserver.domain.feed.domain.repository;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedAttachmentFileEntity;
import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FeedAttachmentFileRepository extends CrudRepository<FeedAttachmentFileEntity, UUID> {

    void deleteByFeed(FeedEntity feed);

}
