package com.moiza.moizaspringbootserver.user.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.user.api.UserDeleteApi;
import com.moiza.moizaspringbootserver.user.spi.CommandUserSpi;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UserDeleteUseCase implements UserDeleteApi {
    private final CommandUserSpi commandUserSpi;
    private final QueryUserSpi queryUserSpi;

    @Override
    public void execute() {
        commandUserSpi.deleteUser(queryUserSpi.queryCurrentUser());
    }
}
