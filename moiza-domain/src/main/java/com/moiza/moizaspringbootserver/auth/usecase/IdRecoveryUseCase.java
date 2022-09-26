package com.moiza.moizaspringbootserver.auth.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.api.IdRecoveryApi;
import com.moiza.moizaspringbootserver.auth.api.dto.response.IdRecoveryResponse;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class IdRecoveryUseCase implements IdRecoveryApi {

    private final QueryUserSpi queryUserSpi;

    @Override
    public IdRecoveryResponse execute(String email) {
        User user = queryUserSpi.getUserByEmail(email);

        return IdRecoveryResponse.builder()
                .accountId(user.getAccountId())
                .name(user.getName())
                .build();
    }
}
