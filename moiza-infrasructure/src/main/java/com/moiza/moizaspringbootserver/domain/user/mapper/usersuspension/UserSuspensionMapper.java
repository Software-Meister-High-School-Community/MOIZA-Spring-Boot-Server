package com.moiza.moizaspringbootserver.domain.user.mapper.usersuspension;

import com.moiza.moizaspringbootserver.domain.user.domain.UserSuspensionEntity;
import com.moiza.moizaspringbootserver.user.domain.UserSuspension;

public interface UserSuspensionMapper {

    UserSuspensionEntity userSuspensionDomainToEntity(UserSuspension userSuspension);

    UserSuspension userSuspensionEntityToDomain(UserSuspensionEntity userSuspension);

}
