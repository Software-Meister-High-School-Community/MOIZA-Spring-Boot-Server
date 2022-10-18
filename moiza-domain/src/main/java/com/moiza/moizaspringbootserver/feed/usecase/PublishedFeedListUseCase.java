package com.moiza.moizaspringbootserver.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.feed.api.PublishedFeedListApi;
import com.moiza.moizaspringbootserver.feed.api.dto.response.PublishedFeedListResponse;
import com.moiza.moizaspringbootserver.feed.api.dto.response.PublishedFeedResponse;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.PublicFeedQuerySpi;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.PublishedFeedPage;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.type.QueryOrders;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
public class PublishedFeedListUseCase implements PublishedFeedListApi {
    private final PublicFeedQuerySpi publicFeedQuerySpi;

    @Override
    public PublishedFeedListResponse execute(UUID userId, String category, String type, String order, int page) {
        PublishedFeedPage pageData = publicFeedQuerySpi.execute(userId, category, FeedType.valueOf(type),
                QueryOrders.valueOf(order), page);

        return PublishedFeedListResponse.builder()
                .totalPage(pageData.getTotalPages())
                .feedList(pageData.getFeeds().stream().map(it -> PublishedFeedResponse.builder()
                                .id(it.getFeed().getFeedId())
                                .commentCount(it.getCommentCount())
                                .liked(it.getLiked())
                                .createdAt(it.getFeed().getCreatedAt().toString())
                                .likeCount(it.getFeed().getLikeCount())
                                .viewCount(it.getFeed().getViewCount())
                                .type(it.getType())
                        .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
