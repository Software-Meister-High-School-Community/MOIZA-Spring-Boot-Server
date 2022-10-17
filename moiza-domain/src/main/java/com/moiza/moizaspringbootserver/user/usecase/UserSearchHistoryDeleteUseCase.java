package com.moiza.moizaspringbootserver.user.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.user.api.UserSearchHistoryDeleteApi;
import com.moiza.moizaspringbootserver.user.domain.SearchHistory;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.exception.HistoryPermissionDeniedException;
import com.moiza.moizaspringbootserver.user.spi.QuerySearchHistorySpi;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class UserSearchHistoryDeleteUseCase implements UserSearchHistoryDeleteApi {
    private final QueryUserSpi queryUserSpi;
    private final AuthSecuritySpi authSecuritySpi;
    private final QuerySearchHistorySpi querySearchHistorySpi;

    @Override
    public void execute(UUID historyId) {
        User queryUser = queryUserSpi.queryUserById(authSecuritySpi.getCurrentUserId());

        SearchHistory history = querySearchHistorySpi.querySearchHistoryById(historyId);
        if(!queryUser.getId().equals(history.getUserId())) throw HistoryPermissionDeniedException.EXCEPTION;

        querySearchHistorySpi.deleteSearchHistoryById(historyId);
    }
}
