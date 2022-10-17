package com.moiza.moizaspringbootserver.domain.feed.domain.repository.custom;

import com.moiza.moizaspringbootserver.domain.feed.domain.PublicFeedEntity;
import com.moiza.moizaspringbootserver.domain.feed.mapper.PublicFeedMapper;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.PublishedFeedQuerySpi;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.CombinedFeed;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.PublishedFeedPage;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.moiza.moizaspringbootserver.domain.feed.domain.QPublicFeedEntity.*;
import static com.moiza.moizaspringbootserver.domain.feed.domain.QFeedLikeEntity.*;

@RequiredArgsConstructor
public class PublicFeedRepositoryCustomImpl implements PublicFeedRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final PublicFeedMapper publicFeedMapper;

    @Override
    public PublishedFeedPage getPublicFeed(UUID userId, String category, FeedType type, PublishedFeedQuerySpi.Orders order, int page) {
        List<BooleanExpression> conditions = new ArrayList<>();
        List<OrderSpecifier<Long>> orders = new ArrayList<>();

        switch (order) {
            case LATEST -> orders.add(new OrderSpecifier<>(Order.DESC, publicFeedEntity.createdAt.castToNum(Long.class)));
            case OLDEST -> orders.add(new OrderSpecifier<>(Order.ASC, publicFeedEntity.createdAt.castToNum(Long.class)));
            case LIKE_COUNT -> orders.add(new OrderSpecifier<>(Order.DESC, publicFeedEntity.likeCount.castToNum(Long.class)));
            case VIEW_COUNT -> orders.add(new OrderSpecifier<>(Order.DESC, publicFeedEntity.viewCount.castToNum(Long.class)));
        }

        if(userId != null) conditions.add(publicFeedEntity.feed.user.id.eq(userId));
        if(category != null) conditions.add(publicFeedEntity.feed.category.categoryName.eq(category));

        JPAQuery<PublicFeedEntity> query = jpaQueryFactory.selectFrom(publicFeedEntity)
                .where(conditions.toArray(new BooleanExpression[0]));

        FeedLikeEntity likeEntity = jpaQueryFactory.selectFrom(feedLikeEntity)
                .where(feedLikeEntity.id.user.id.eq(userId))
                .fetchOne();

        List<PublicFeedEntity> entities = query
                .orderBy(orders.toArray(new OrderSpecifier[0]))
                .offset(page * 10L).limit(10)
                .fetchJoin()
                .fetch();

        List<CombinedFeed> feeds = entities.stream()
                .map(it -> CombinedFeed.builder()
                        .commentCount(it.getFeed().getComments().size())
                        .liked(likeEntity != null)
                        .type(it.getFeed().getFeedType())
                        .feed(publicFeedMapper.publicFeedEntityToDomain(it))
                        .build()).toList();

        return PublishedFeedPage.builder()
                .totalPages(query.fetch().size())
                .feeds(feeds)
                .build();
    }
}
