package com.moiza.moizaspringbootserver.user.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.user.api.SearchAllUsersApi;
import com.moiza.moizaspringbootserver.user.api.dto.response.SearchAllUsersResponse;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SearchAllUserUseCase implements SearchAllUsersApi {

    private final QueryUserSpi queryUserSpi;

    @Override
    public SearchAllUsersResponse execute(String name, Integer page) {
        return queryUserSpi.querySearchAllUsers(name, page);
    }
}
