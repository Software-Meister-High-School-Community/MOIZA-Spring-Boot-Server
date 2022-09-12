package com.moiza.moizaspringbootserver.domain.user.mapper;

import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity userDomainToEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .accountId(user.getAccountId())
                .password(user.getPassword())
                .name(user.getName())
                .sex(user.getSex())
                .birthDay(user.getBirthDay())
                .introduce(user.getIntroduce())
                .userType(user.getUserType())
                .school(user.getSchool())
                .build();
    }

    @Override
    public User userEntityToDomain(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .accountId(userEntity.getAccountId())
                .password(userEntity.getPassword())
                .name(userEntity.getName())
                .sex(userEntity.getSex())
                .birthDay(userEntity.getBirthDay())
                .introduce(userEntity.getIntroduce())
                .userType(userEntity.getUserType())
                .school(userEntity.getSchool())
                .build();
    }
}
