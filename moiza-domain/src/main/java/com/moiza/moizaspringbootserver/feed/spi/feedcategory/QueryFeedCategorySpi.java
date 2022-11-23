package com.moiza.moizaspringbootserver.feed.spi.feedcategory;

import com.moiza.moizaspringbootserver.feed.Category;

public interface QueryFeedCategorySpi {
    Category queryCategoryByCategoryName(String categoryName);
}
