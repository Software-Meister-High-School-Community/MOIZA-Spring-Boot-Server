package com.moiza.moizaspringbootserver.domain.like.mapper;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.FeedRepository;
import com.moiza.moizaspringbootserver.domain.like.domain.FeedLikeEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.feed.exception.FeedNotFoundException;
import com.moiza.moizaspringbootserver.like.FeedLike;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class FeedLikeMapperImpl implements FeedLikeMapper {

    private final FeedRepository feedRepository;
    private final UserRepository userRepository;

    @Override
    public FeedLike feedLikeEntityToDomain(FeedLikeEntity feedLikeEntity) {
        return FeedLike.builder()
                .feedId(feedLikeEntity.getId().getFeed())
                .createdAt(feedLikeEntity.getCreatedAt())
                .userId(feedLikeEntity.getId().getFeed())
                .build();
    }

    @Override
    public FeedLikeEntity feedLikeDomainToEntity(FeedLike feedLike) {
        return FeedLikeEntity.builder()
                .user(findByUserId(feedLike.getFeedId()))
                .feed(findByFeedLikeId(feedLike.getFeedId()))

                .build();
    }

    private FeedEntity findByFeedLikeId(UUID id) {
        return feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }

    private UserEntity findByUserId(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
