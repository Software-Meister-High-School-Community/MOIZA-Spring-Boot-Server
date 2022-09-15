package com.moiza.moizaspringbootserver.domain.user.mapper;

import com.moiza.moizaspringbootserver.domain.user.domain.UserSuspensionEntity;
import com.moiza.moizaspringbootserver.user.UserSuspension;

public interface UserSuspensionMapper {

    UserSuspensionEntity userSuspensionDomainToEntity(UserSuspension userSuspension);

    UserSuspension userSuspensionEntityToDomain(UserSuspensionEntity userSuspension);

}
