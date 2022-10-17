package com.moiza.moizaspringbootserver.feed.spi.feedcategory;

import com.moiza.moizaspringbootserver.feed.Feed;

public interface CommandFeedCategorySpi {
    void deleteCategory(Feed feed);
}
