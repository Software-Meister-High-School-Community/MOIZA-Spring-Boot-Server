package com.moiza.moizaspringbootserver.domain.feed.domain.adapter.feedcategory;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.FeedCategoryRepository;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedMapper;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.spi.feedcategory.FeedCategorySpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class FeedCategoryPersistenceAdapter implements FeedCategorySpi {

    private final FeedMapper feedMapper;
    private final FeedCategoryRepository feedCategoryRepository;

    @Override
    public void deleteCategory(Feed feed) {
        feedCategoryRepository.deleteByFeed(
                feedMapper.feedDomainToEntity(feed)
        );
    }
}
