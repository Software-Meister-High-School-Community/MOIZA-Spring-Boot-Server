package com.moiza.moizaspringbootserver.domain.user.mapper.userdevicetoken;

import com.moiza.moizaspringbootserver.domain.user.domain.UserDeviceTokenEntity;
import com.moiza.moizaspringbootserver.user.domain.UserDeviceToken;

public interface UserDeviceTokenMapper {

    UserDeviceTokenEntity userDeviceTokenDomainToEntity(UserDeviceToken userDeviceToken);
    UserDeviceToken userDeviceTokenEntityToDomain(UserDeviceTokenEntity userDeviceTokenEntity);

}
