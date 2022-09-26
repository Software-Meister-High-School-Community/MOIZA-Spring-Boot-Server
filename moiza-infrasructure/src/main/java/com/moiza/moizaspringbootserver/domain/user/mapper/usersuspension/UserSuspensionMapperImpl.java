package com.moiza.moizaspringbootserver.domain.user.mapper.usersuspension;

import com.moiza.moizaspringbootserver.domain.user.domain.UserSuspensionEntity;
import com.moiza.moizaspringbootserver.user.domain.UserSuspension;
import org.springframework.stereotype.Component;

@Component
public class UserSuspensionMapperImpl implements UserSuspensionMapper {

    @Override
    public UserSuspensionEntity userSuspensionDomainToEntity(UserSuspension userSuspension) {
        return UserSuspensionEntity.builder()
                .expiredAt(userSuspension.getExpiredAt())
                .build();
    }

    @Override
    public UserSuspension userSuspensionEntityToDomain(UserSuspensionEntity userSuspension) {
        return UserSuspension.builder()
                .userId(userSuspension.getId())
                .expiredAt(userSuspension.getExpiredAt())
                .build();
    }
}
