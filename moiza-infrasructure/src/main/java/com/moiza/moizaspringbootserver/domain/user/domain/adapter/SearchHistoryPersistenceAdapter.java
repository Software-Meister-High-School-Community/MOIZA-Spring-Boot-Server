package com.moiza.moizaspringbootserver.domain.user.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.user.domain.SearchHistoryEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.SearchHistoryRepository;
import com.moiza.moizaspringbootserver.domain.user.mapper.history.SearchHistoryMapper;
import com.moiza.moizaspringbootserver.user.domain.SearchHistory;
import com.moiza.moizaspringbootserver.user.exception.SearchHistoryNotFoundException;
import com.moiza.moizaspringbootserver.user.spi.SearchHistorySpi;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Adapter
public class SearchHistoryPersistenceAdapter implements SearchHistorySpi {

    private final SearchHistoryRepository searchHistoryRepository;
    private final SearchHistoryMapper searchHistoryMapper;

    @Override
    public List<SearchHistory> querySearchHistoryAllByUserId(UUID id) {
        List<SearchHistoryEntity> searchHistories = searchHistoryRepository.findAllByUserEntityId(id);

        return searchHistories.stream().map(
                it -> SearchHistory.builder()
                        .id(it.getId())
                        .userId(id)
                        .keyword(it.getKeyword())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public SearchHistory querySearchHistoryById(UUID historyId) {
        return searchHistoryMapper.searchHistoryEntityToDomain(searchHistoryRepository.findById(historyId)
                .orElseThrow(() -> SearchHistoryNotFoundException.EXCEPTION));
    }

    @Override
    public void deleteSearchHistoryById(UUID historyId) {
        searchHistoryRepository.deleteById(historyId);
    }
}
