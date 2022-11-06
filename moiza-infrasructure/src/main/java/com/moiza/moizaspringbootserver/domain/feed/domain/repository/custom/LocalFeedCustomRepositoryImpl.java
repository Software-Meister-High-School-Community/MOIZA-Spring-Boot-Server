package com.moiza.moizaspringbootserver.domain.feed.domain.repository.custom;

import com.moiza.moizaspringbootserver.domain.feed.mapper.LocalFeedMapper;
import com.moiza.moizaspringbootserver.feed.LocalFeed;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

import static com.moiza.moizaspringbootserver.domain.feed.domain.QLocalFeedEntity.*;

@RequiredArgsConstructor
public class LocalFeedCustomRepositoryImpl implements LocalFeedCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;
    private final LocalFeedMapper localFeedMapper;

    @Override
    public List<LocalFeed> getAllLocalFeedByTypeAndKeyword(User user, FeedType type, String keyword) {
        return jpaQueryFactory.selectFrom(localFeedEntity)
                .where(localFeedEntity.feed.user.id.eq(user.getId()),
                        localFeedEntity.feed.feedType.eq(type),
                        localFeedEntity.feed.category.categoryName.eq(keyword))
                .fetchAll()
                .stream()
                .map(localFeedMapper::localFeedEntityToDomain)
                .collect(Collectors.toList());
    }
}
