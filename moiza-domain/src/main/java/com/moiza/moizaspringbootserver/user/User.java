package com.moiza.moizaspringbootserver.user;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import com.moiza.moizaspringbootserver.user.enums.School;
import com.moiza.moizaspringbootserver.user.enums.Sex;
import com.moiza.moizaspringbootserver.user.enums.UserType;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class User {

    private final UUID id;
    private final String email;
    private final String accountId;
    private final String password;
    private final String name;
    private final String profileImageUrl;
    private final String profileBackgroundColor;
    private final Sex sex;
    private final String birthDay;
    private final String introduce;
    private final UserType userType;
    private final School school;

    public void setPassword(String encodePassword) {
        User.builder()
                .password(encodePassword)
                .build();
    }
}
