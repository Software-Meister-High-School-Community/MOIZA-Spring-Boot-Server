package com.moiza.moizaspringbootserver.domain.user.domain.repository.vo;


import com.moiza.moizaspringbootserver.user.domain.enums.School;
import com.moiza.moizaspringbootserver.user.domain.enums.UserType;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class QuerySearchAllUsersVO {

    private final UUID userId;
    private final String name;
    private final String profileImageUrl;
    private final UserType userType;
    private final School school;

    @QueryProjection
    @Builder
    public QuerySearchAllUsersVO(UUID userId, String name, String profileImageUrl, UserType userType, School school) {
        this.userId = userId;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.userType = userType;
        this.school = school;
    }
}
