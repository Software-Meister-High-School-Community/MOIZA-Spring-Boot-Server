package com.moiza.moizaspringbootserver.domain.user.mapper;

import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.user.domain.User;

public interface UserMapper {
    UserEntity userDomainToEntity(User user);
    User userEntityToDomain(UserEntity userEntity);
}
