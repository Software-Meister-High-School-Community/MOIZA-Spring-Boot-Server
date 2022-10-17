package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.user.domain.SearchHistory;

import java.util.List;
import java.util.UUID;

public interface QuerySearchHistorySpi {
    List<SearchHistory> querySearchHistoryAllByUserId(UUID id);

    SearchHistory querySearchHistoryById(UUID historyId);

    void deleteSearchHistoryById(UUID historyId);
}
