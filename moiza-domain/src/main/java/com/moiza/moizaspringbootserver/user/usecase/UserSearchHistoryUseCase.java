package com.moiza.moizaspringbootserver.user.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.user.api.UserSearchHistoryApi;
import com.moiza.moizaspringbootserver.user.api.dto.response.UserSearchHistoryResponse;
import com.moiza.moizaspringbootserver.user.api.dto.response.UserSearchHistoryResponse.Keywords;
import com.moiza.moizaspringbootserver.user.domain.SearchHistory;
import com.moiza.moizaspringbootserver.user.spi.QuerySearchHistorySpi;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
public class UserSearchHistoryUseCase implements UserSearchHistoryApi {

    private final AuthSecuritySpi authSecuritySpi;
    private final QuerySearchHistorySpi querySearchHistorySpi;

    @Override
    public UserSearchHistoryResponse execute() {
        UUID userId = authSecuritySpi.getCurrentUserId();
        List<SearchHistory> searchHistories = querySearchHistorySpi.querySearchHistoryAllByUserId(userId);
        List<Keywords> keywords = searchHistories
                .stream()
                .map(it -> Keywords.builder()
                        .historyId(it.getId())
                        .keyword(it.getKeyword())
                        .build()
                ).collect(Collectors.toList());

        return new UserSearchHistoryResponse(keywords);
    }
}
