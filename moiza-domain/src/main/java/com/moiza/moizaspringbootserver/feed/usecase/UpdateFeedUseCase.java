package com.moiza.moizaspringbootserver.feed.usecase;


import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.PublicFeed;
import com.moiza.moizaspringbootserver.feed.api.UpdateFeedApi;
import com.moiza.moizaspringbootserver.feed.api.dto.request.DomainUpdateFeedRequest;
import com.moiza.moizaspringbootserver.feed.spi.feed.CommandFeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.feed.QueryFeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.feedattachmentfile.CommandFeedAttachmentFileSpi;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.CommandPublicFeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.QueryPublicFeedSpi;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class UpdateFeedUseCase implements UpdateFeedApi {

    private final QueryPublicFeedSpi queryPublicFeedSpi;
    private final QueryFeedSpi queryFeedSpi;

    private final CommandFeedSpi commandFeedSpi;

    private final CommandPublicFeedSpi commandPublicFeedSpi;

    private final CommandFeedAttachmentFileSpi commandFeedAttachmentFileSpi;

    @Override
    public void execute(UUID feedId, DomainUpdateFeedRequest request) {

        Feed feed = queryFeedSpi.queryFeedById(feedId);
        Feed updatedFeed = Feed.builder()
                .id(feed.getId())
                .userId(feed.getUserId())
                .feedType(request.getFeedType())
                .build();
        //Todo 저장

        PublicFeed publicFeed = queryPublicFeedSpi.queryPublicFeedByFeedId(feedId);
        PublicFeed updatedPublicFeed = PublicFeed.builder()
                .feedId(publicFeed.getFeedId())
                .title(request.getTitle())
                .content(request.getContent())
                .createdAt(publicFeed.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .likeCount(publicFeed.getLikeCount())
                .viewCount(publicFeed.getViewCount())
                .build();
        //Todo 저장

        commandFeedAttachmentFileSpi.deleteAllFeedAttachmentFileByFeedId(feed)
        request.getImageUrls().forEach(
                image -> {
                    //Todo 저장
                }
        );
        
    }
}
