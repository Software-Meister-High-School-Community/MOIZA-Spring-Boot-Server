package com.moiza.moizaspringbootserver.domain.feed.domain.adapter.publicfeed;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.domain.PublicFeedEntity;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.PublicFeedRepository;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.custom.PublicFeedRepositoryCustom;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedMapper;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.dto.response.QueryAllFeedsResponse;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.dto.response.QueryAllFeedsResponse.Result;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.PublishedFeedPage;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.PublicFeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.type.QueryOrders;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import static com.moiza.moizaspringbootserver.domain.feed.domain.QCategoryEntity.categoryEntity;
import static com.moiza.moizaspringbootserver.domain.feed.domain.QPublicFeedEntity.publicFeedEntity;
import static com.moiza.moizaspringbootserver.domain.comment.domain.QCommentEntity.commentEntity;

@RequiredArgsConstructor
@Adapter
public class PublicFeedPersistenceAdapter implements PublicFeedSpi {

    private final FeedMapper feedMapper;
    private final PublicFeedRepository publicFeedRepository;
    private final PublicFeedRepositoryCustom publicFeedRepositoryCustom;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public void deletePublicFeedByFeedId(Feed feed) {
        publicFeedRepository.deleteByFeed(
                feedMapper.feedDomainToEntity(feed)
        );
    }

    @Override
    public PublishedFeedPage getAllPublishedFeed(UUID userId, String category, FeedType type, QueryOrders order, int page) {
        return publicFeedRepositoryCustom.getPublicFeed(userId, category, type, order, page);
    }

    @Override
    public QueryAllFeedsResponse queryAllFeedsByNameAndCategory(String name, String category, FeedType type, QueryOrders order, Integer page) {
        long size = 10;

        Integer commentCount = jpaQueryFactory
                .select(commentEntity.count())
                .from(commentEntity)
                .join(commentEntity).on(publicFeedEntity.feed.id.eq(commentEntity.feedEntity.id))
                .fetchFirst().intValue();


        List<PublicFeedEntity> publicFeedEntities = jpaQueryFactory.selectFrom(publicFeedEntity)
                .where(eqCategory(category))
                .where(eqType(type))
                .where(containsName(name))
                .join(categoryEntity, publicFeedEntity.feed.category)
                .join(commentEntity).on(publicFeedEntity.feed.id.eq(commentEntity.feedEntity.id))
                .offset((long) page * size)
                .limit(size)
                .orderBy(getOrder(order))
                .fetch();

        return QueryAllFeedsResponse.builder()
                .totalPage(publicFeedEntities.size())
                .feedList(publicFeedEntities.stream()
                        .map(it -> Result.builder()
                                .id(it.getId())
                                .title(it.getTitle())
                                .type(it.getFeed().getFeedType())
                                .createdAt(it.getCreatedAt())
                                .viewCount(it.getViewCount())
                                .likeCount(it.getLikeCount())
                                .commentCount(commentCount)
                                .build())
                        .toList())
                .build();
    }

    private OrderSpecifier<?> getOrder(QueryOrders order) {
        return switch (order.name()) {
            case "LATEST" -> publicFeedEntity.createdAt.asc();
            case "OLDEST" -> publicFeedEntity.createdAt.desc();
            case "VIEW_COUNT" -> publicFeedEntity.viewCount.desc();
            case "LIKE_COUNT" -> publicFeedEntity.likeCount.desc();
        };
    }

    private BooleanExpression eqCategory(String category) {
        if (category.isEmpty()) {
            return null;
        }
        return categoryEntity.categoryName.eq(category);
    }

    private BooleanExpression eqType(FeedType type) {
        if (type.name().isEmpty()) {
            return null;
        }
        return publicFeedEntity.feed.feedType.eq(type);
    }

    private BooleanExpression containsName(String name) {
        if (name.isEmpty()) {
            return null;
        }
        return publicFeedEntity.title.contains(name);
    }
}
