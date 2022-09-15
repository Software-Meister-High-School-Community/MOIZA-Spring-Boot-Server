package com.moiza.moizaspringbootserver.domain.user.mapper.user;

import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.user.User;

public interface UserMapper {
    UserEntity userDomainToEntity(User user);
    User userEntityToDomain(UserEntity userEntity);
}
