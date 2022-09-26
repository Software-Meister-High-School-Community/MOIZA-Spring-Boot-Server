package com.moiza.moizaspringbootserver.auth.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.api.UpdatePasswordApi;
import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainUpdatePasswordRequest;
import com.moiza.moizaspringbootserver.auth.exception.InvalidPasswordException;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.user.User;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UpdatePasswordUseCase implements UpdatePasswordApi {

    private final QueryUserSpi queryUserSpi;
    private final AuthSecuritySpi authSecuritySpi;

    @Override
    public void execute(DomainUpdatePasswordRequest request) {
        User currentUser = queryUserSpi.queryUserById(authSecuritySpi.getCurrentUserId());

        if (!authSecuritySpi.matches(request.getNewPassword(), currentUser.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }


        currentUser.setPassword(authSecuritySpi.encodePassword(request.getNewPassword()));

    }
}
