package com.moiza.moizaspringbootserver.domain.user.domain;

import com.moiza.moizaspringbootserver.auth.spi.IdValidationSpi;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserValidationAdapter implements IdValidationSpi {

    private final UserRepository userRepository;

    @Override
    public boolean isUserExists(String accountId) {
        return userRepository.findByAccountId(accountId)
                .isPresent();
    }
}
