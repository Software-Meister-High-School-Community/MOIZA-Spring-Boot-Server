package com.moiza.moizaspringbootserver.domain.feed.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.custom.PublicFeedRepositoryCustom;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.PublishedFeedQuerySpi;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.PublishedFeedPage;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class PublishedFeedQueryAdapter implements PublishedFeedQuerySpi {
    private final PublicFeedRepositoryCustom publicFeedRepositoryCustom;

    @Override
    public PublishedFeedPage execute(UUID userId, String category, FeedType type, Orders order, int page) {
        return publicFeedRepositoryCustom.getPublicFeed(userId, category, type, order, page);
    }
}
