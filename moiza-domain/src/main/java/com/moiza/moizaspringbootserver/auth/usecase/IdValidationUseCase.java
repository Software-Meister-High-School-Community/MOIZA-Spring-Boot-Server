package com.moiza.moizaspringbootserver.auth.usecase;

import com.moiza.moizaspringbootserver.auth.api.IdValidationApi;
import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainIdValidationRequest;
import com.moiza.moizaspringbootserver.auth.exception.UserAlredayExistException;
import com.moiza.moizaspringbootserver.auth.spi.IdValidationSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IdValidationUseCase implements IdValidationApi {

    private final IdValidationSpi idValidationSpi;

    @Override
    public void validId(DomainIdValidationRequest request) {
        if(idValidationSpi.isUserExists(request.getAccountId()))
            throw UserAlredayExistException.EXCEPTION;
    }
}
