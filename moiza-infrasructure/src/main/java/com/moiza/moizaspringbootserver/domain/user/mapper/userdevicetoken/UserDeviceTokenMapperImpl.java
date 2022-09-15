package com.moiza.moizaspringbootserver.domain.user.mapper;

import com.moiza.moizaspringbootserver.domain.user.domain.UserDeviceTokenEntity;
import com.moiza.moizaspringbootserver.user.UserDeviceToken;
import org.springframework.stereotype.Component;

@Component
public class UserDeviceTokenMapperImpl implements UserDeviceTokenMapper{

    @Override
    public UserDeviceTokenEntity userDeviceTokenDomainToEntity(UserDeviceToken userDeviceToken) {
        return UserDeviceTokenEntity.builder()
                .appDeviceToken(userDeviceToken.getAppDeviceToken())
                .webDeviceToken(userDeviceToken.getWebDeviceToken())
                .build();
    }

    @Override
    public UserDeviceToken userDeviceTokenEntityToDomain(UserDeviceTokenEntity userDeviceTokenEntity) {
        return UserDeviceToken.builder()
                .appDeviceToken(userDeviceTokenEntity.getAppDeviceToken())
                .appDeviceToken(userDeviceTokenEntity.getAppDeviceToken())
                .build();
    }
}
