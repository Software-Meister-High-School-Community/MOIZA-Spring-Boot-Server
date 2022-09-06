package com.moiza.moizaspringbootserver.domain.user.mapper;

import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity userDomainToEntity(User user) {
        return null;
    }

    @Override
    public User userEntityToDomain(UserEntity userEntity) {
        return null;
    }
}
