package com.moiza.moizaspringbootserver.domain.user.mapper;

import com.moiza.moizaspringbootserver.domain.user.domain.UserDeviceTokenEntity;
import com.moiza.moizaspringbootserver.user.UserDeviceToken;

public interface UserDeviceTokenMapper {

    UserDeviceTokenEntity userDeviceTokenDomainToEntity(UserDeviceToken userDeviceToken);
    UserDeviceToken userDeviceTokenEntityToDomain(UserDeviceTokenEntity userDeviceTokenEntity);

}
