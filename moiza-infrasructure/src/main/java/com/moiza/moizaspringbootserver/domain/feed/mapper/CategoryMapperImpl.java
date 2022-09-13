package com.moiza.moizaspringbootserver.domain.feed.mapper;

import com.moiza.moizaspringbootserver.domain.feed.domain.CategoryEntity;
import com.moiza.moizaspringbootserver.feed.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category categoryEntityToDomain(CategoryEntity categoryEntity) {
        return Category.builder()
                .id(categoryEntity.getId())
                .categoryName(categoryEntity.getCategoryName())
                .build();
    }

    @Override
    public CategoryEntity categoryDomainToEntity(Category category) {
        return CategoryEntity.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .build();
    }
}
