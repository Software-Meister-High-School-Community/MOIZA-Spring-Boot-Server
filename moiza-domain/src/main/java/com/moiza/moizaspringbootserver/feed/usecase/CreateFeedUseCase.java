package com.moiza.moizaspringbootserver.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.Category;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.FeedAttachmentFile;
import com.moiza.moizaspringbootserver.feed.PublicFeed;
import com.moiza.moizaspringbootserver.feed.api.CreateFeedApi;
import com.moiza.moizaspringbootserver.feed.api.dto.request.DomainCreateFeedRequest;
import com.moiza.moizaspringbootserver.feed.spi.feed.CommandFeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.feedattachmentfile.CommandFeedAttachmentFileSpi;
import com.moiza.moizaspringbootserver.feed.spi.feedcategory.QueryFeedCategorySpi;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.PublicFeedSpi;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class CreateFeedUseCase implements CreateFeedApi {

    private final AuthSecuritySpi authSecuritySpi;
    private final CommandFeedSpi commandFeedSpi;
    private final PublicFeedSpi publicFeedSpi;
    private final QueryFeedCategorySpi queryFeedCategorySpi;
    private final CommandFeedAttachmentFileSpi commandFeedAttachmentFileSpi;

    @Override
    public void execute(DomainCreateFeedRequest request) {

        UUID userId = authSecuritySpi.getCurrentUserId();

        Category category = queryFeedCategorySpi.queryCategoryByCategoryName(request.getCategory());

        Feed feed = Feed.builder()
                .feedType(request.getFeedType())
                .userId(userId)
                .categoryId(category.getId())
                .build();

        Feed feedEntity = commandFeedSpi.saveFeed(feed);

        request.getImageUrls().forEach(
                image -> commandFeedAttachmentFileSpi.saveFeedAttachmentFile(
                        FeedAttachmentFile.builder()
                                .feedId(feedEntity.getId())
                                .attachmentFileUrl(image)
                                .build()
                )
        );


        PublicFeed publicFeed = PublicFeed.builder()
                .feedId(feedEntity.getId())
                .title(request.getTitle())
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .likeCount(0)
                .viewCount(0)
                .build();

        publicFeedSpi.savePublicFeed(publicFeed);
    }
}
