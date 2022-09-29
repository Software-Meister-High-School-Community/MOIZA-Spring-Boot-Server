package com.moiza.moizaspringbootserver.user.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.user.api.UserDeleteApi;
import com.moiza.moizaspringbootserver.user.spi.CommandUserSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UserDeleteUseCase implements UserDeleteApi {
    private final CommandUserSpi commandUserSpi;
    private final AuthSecuritySpi authSecuritySpi;

    @Override
    public void execute() {
        commandUserSpi.deleteUserById(authSecuritySpi.getCurrentUserId());
    }
}
