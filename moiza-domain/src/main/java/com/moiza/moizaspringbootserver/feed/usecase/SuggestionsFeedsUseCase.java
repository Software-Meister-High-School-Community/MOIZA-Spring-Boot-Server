package com.moiza.moizaspringbootserver.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.PublicFeed;
import com.moiza.moizaspringbootserver.feed.api.SuggestionsFeedsApi;
import com.moiza.moizaspringbootserver.feed.api.dto.response.SuggestionsFeedsResponse;
import com.moiza.moizaspringbootserver.feed.api.dto.response.SuggestionsFeedsResponse.SuggestionFeed;
import com.moiza.moizaspringbootserver.feed.spi.feed.FeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.feed.QueryFeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.PublicFeedQuerySpi;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import lombok.RequiredArgsConstructor;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RequiredArgsConstructor
@UseCase
public class SuggestionsFeedsUseCase implements SuggestionsFeedsApi {

    private final PublicFeedQuerySpi publicFeedQuerySpi;

    private final QueryFeedSpi queryFeedSpi;

    private final QueryUserSpi queryUserSpi;

    @Override
    public SuggestionsFeedsResponse execute(String category, Integer size) {
        List<SuggestionFeed> suggestionFeeds = new ArrayList<>(publicFeedQuerySpi.getPublicFeedsByCategory(category)
                .stream()
                .map(it -> SuggestionFeed.builder()
                        .title(it.getTitle())
                        .type(queryFeedSpi.queryByFeedId(it.getFeedId()).getFeedType())
                        .createdAt(it.getCreatedAt())
                        .authorName(getAuthorName(it))
                        .build())
                .toList());

        Collections.shuffle(suggestionFeeds);

        List<SuggestionFeed> destSuggestionFeeds = new ArrayList<>();

        System.arraycopy(suggestionFeeds, 0, destSuggestionFeeds, 0,size - 1);

        return new SuggestionsFeedsResponse(destSuggestionFeeds);
    }

    private String getAuthorName(PublicFeed publicFeed) {
        return queryUserSpi.queryUserById(queryFeedSpi.queryByFeedId(publicFeed.getFeedId()).getUserId()).getName();
    }
}
