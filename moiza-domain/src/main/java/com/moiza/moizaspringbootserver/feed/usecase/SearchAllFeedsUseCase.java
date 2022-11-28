package com.moiza.moizaspringbootserver.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.dto.response.QueryAllFeedsResponse;
import com.moiza.moizaspringbootserver.feed.api.SearchAllFeedsApi;
import com.moiza.moizaspringbootserver.feed.api.dto.response.SearchAllFeedsResponse;
import com.moiza.moizaspringbootserver.feed.api.dto.response.SearchAllFeedsResponse.SearchResult;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.feed.QueryFeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.PublicFeedQuerySpi;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.type.QueryOrders;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class SearchAllFeedsUseCase implements SearchAllFeedsApi {

    private final AuthSecuritySpi authSecuritySpi;
    private final PublicFeedQuerySpi publicFeedQuerySpi;
    private final QueryFeedSpi queryFeedSpi;

    @Override
    public SearchAllFeedsResponse execute(String name, String category, FeedType type, QueryOrders order, Integer page) {
        UUID currentUserId = authSecuritySpi.getCurrentUserId();
        QueryAllFeedsResponse queryAllFeedsResponse = publicFeedQuerySpi.queryAllFeedsByNameAndCategory(name, category, type, page);

        Integer totalPage = queryAllFeedsResponse.getTotalPage();

        List<SearchResult> feedList = queryAllFeedsResponse.getFeedList()
                .stream()
                .map(it -> SearchResult.builder()
                        .id(it.getId())
                        .title(it.getTitle())
                        .type(it.getType())
                        .createdAt(it.getCreatedAt())
                        .isLike(queryFeedSpi.compareFeedUserId(it.getId(), currentUserId))
                        .viewCount(it.getViewCount())
                        .likeCount(it.getLikeCount())
                        .commentCount(it.getCommentCount())
                        .build()
                ).toList();

        return SearchAllFeedsResponse.builder()
                .totalPage(totalPage)
                .feedList(feedList)
                .build();
    }
}
