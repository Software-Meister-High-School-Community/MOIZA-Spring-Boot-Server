package com.moiza.moizaspringbootserver.domain.user.mapper.userdevicetoken;

import com.moiza.moizaspringbootserver.domain.user.domain.UserDeviceTokenEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.user.domain.UserDeviceToken;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserDeviceTokenMapperImpl implements UserDeviceTokenMapper{

    private final UserRepository userRepository;

    @Override
    public UserDeviceTokenEntity userDeviceTokenDomainToEntity(UserDeviceToken userDeviceToken) {
        UserEntity userEntity = userRepository.findById(userDeviceToken.getUserId())
            .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return UserDeviceTokenEntity.builder()
                .appDeviceToken(userDeviceToken.getAppDeviceToken())
                .webDeviceToken(userDeviceToken.getWebDeviceToken())
                .userEntity(userEntity)
                .build();
    }

    @Override
    public UserDeviceToken userDeviceTokenEntityToDomain(UserDeviceTokenEntity userDeviceTokenEntity) {
        return UserDeviceToken.builder()
                .appDeviceToken(userDeviceTokenEntity.getAppDeviceToken())
                .appDeviceToken(userDeviceTokenEntity.getAppDeviceToken())
                .userId(userDeviceTokenEntity.getUserEntity().getId())
                .build();
    }
}
