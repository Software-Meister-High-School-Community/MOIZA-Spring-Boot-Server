package com.moiza.moizaspringbootserver.domain.feed.domain.repository.custom;

import com.moiza.moizaspringbootserver.domain.feed.domain.LocalFeedEntity;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import java.util.List;

import static com.moiza.moizaspringbootserver.domain.feed.domain.QLocalFeedEntity.*;

@RequiredArgsConstructor
public class LocalFeedCustomRepositoryImpl implements LocalFeedCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<LocalFeedEntity> getAllLocalFeedByTypeAndKeyword(User user, FeedType type, String keyword) {
        return jpaQueryFactory.selectFrom(qLocalFeedEntity)
                .where(qLocalFeedEntity.feed.user.id.eq(user.getId()),
                        qLocalFeedEntity.feed.feedType.eq(type),
                        qLocalFeedEntity.feed.category.categoryName.eq(keyword))
                .fetchAll();
    }
}
