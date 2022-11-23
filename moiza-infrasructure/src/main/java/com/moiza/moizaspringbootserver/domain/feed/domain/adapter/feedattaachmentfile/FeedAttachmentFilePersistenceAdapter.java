package com.moiza.moizaspringbootserver.domain.feed.domain.adapter.feedattaachmentfile;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.FeedAttachmentFileRepository;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedAttachmentFileMapper;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedMapper;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.FeedAttachmentFile;
import com.moiza.moizaspringbootserver.feed.spi.feedattachmentfile.FeedAttachmentFileSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class FeedAttachmentFilePersistenceAdapter implements FeedAttachmentFileSpi {

    private final FeedMapper feedMapper;
    private final FeedAttachmentFileMapper feedAttachmentFileMapper;
    private final FeedAttachmentFileRepository feedAttachmentFileRepository;

    @Override
    public void deleteAllFeedAttachmentFileByFeedId(Feed feed) {
        feedAttachmentFileRepository.deleteByFeed(
                feedMapper.feedDomainToEntity(feed)
        );
    }

    @Override
    public void saveFeedAttachmentFile(FeedAttachmentFile feedAttachmentFile) {
        feedAttachmentFileMapper.feedAttachmentFileEntityToDomain(
                feedAttachmentFileRepository.save(
                        feedAttachmentFileMapper.feedAttachmentDomainToEntity(feedAttachmentFile)
                )
        );
    }
}
