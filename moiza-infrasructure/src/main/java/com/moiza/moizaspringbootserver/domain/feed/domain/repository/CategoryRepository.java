package com.moiza.moizaspringbootserver.domain.feed.domain.repository;

import com.moiza.moizaspringbootserver.domain.feed.domain.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, UUID> {

}
