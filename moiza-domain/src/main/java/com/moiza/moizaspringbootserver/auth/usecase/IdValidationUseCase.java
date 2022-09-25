package com.moiza.moizaspringbootserver.auth.usecase;

import com.moiza.moizaspringbootserver.auth.api.IdValidationApi;
import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainIdValidationRequest;
import com.moiza.moizaspringbootserver.user.exception.UserAlreadyExistsException;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IdValidationUseCase implements IdValidationApi {

    private final QueryUserSpi queryUserSpi;

    @Override
    public void execute(DomainIdValidationRequest request) {
        if(queryUserSpi.existsUserByAccountId(request.getAccountId()))
            throw UserAlreadyExistsException.EXCEPTION;
    }
}
