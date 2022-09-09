package com.moiza.moizaspringbootserver.domain.feed.mapper;

import com.moiza.moizaspringbootserver.domain.feed.domain.CategoryEntity;
import com.moiza.moizaspringbootserver.feed.Category;

public interface CategoryMapper {
    Category categoryEntityToDomain(CategoryEntity categoryEntity);
    CategoryEntity categoryDomainToEntity(Category category);
}
