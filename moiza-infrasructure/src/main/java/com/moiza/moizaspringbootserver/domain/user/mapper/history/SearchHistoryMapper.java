package com.moiza.moizaspringbootserver.domain.user.mapper.history;

import com.moiza.moizaspringbootserver.domain.user.domain.SearchHistoryEntity;
import com.moiza.moizaspringbootserver.user.domain.SearchHistory;
import org.springframework.stereotype.Component;

@Component
public interface SearchHistoryMapper {

    SearchHistoryEntity searchHistoryDomainToEntity(SearchHistory searchHistory);

    SearchHistory searchHistoryEntityToDomain(SearchHistoryEntity searchHistoryEntity);
}
