package com.moiza.moizaspringbootserver.domain.feed.mapper;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.CategoryRepository;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.exception.CategoryNotFoundException;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedMapperImpl implements FeedMapper {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public FeedEntity feedDomainToEntity(Feed feed) {
        return FeedEntity.builder()
                .id(feed.getId())
                .feedType(feed.getFeedType())
                .user(
                        userRepository.findById(feed.getUserId())
                                .orElseThrow(() -> UserNotFoundException.EXCEPTION)
                )
                .category(
                        categoryRepository.findById(feed.getCategoryId())
                                .orElseThrow(() -> CategoryNotFoundException.EXCEPTION)
                )
                .build();
    }

    @Override
    public Feed feedEntityToDomain(FeedEntity feedEntity) {
        return Feed.builder()
                .id(feedEntity.getId())
                .feedType(feedEntity.getFeedType())
                .categoryId(feedEntity.getCategory().getId())
                .build();
    }
}
