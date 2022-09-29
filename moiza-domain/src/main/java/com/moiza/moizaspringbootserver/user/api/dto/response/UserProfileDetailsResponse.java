package com.moiza.moizaspringbootserver.user.api.dto.response;

import com.moiza.moizaspringbootserver.user.domain.enums.School;
import com.moiza.moizaspringbootserver.user.domain.enums.UserType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
@Builder
public class UserProfileDetailsResponse {
    private final String name;
    private final School school;
    private final UserType userScope;
    private final String profileImageUrl;
    private final String profileBackGroundColor;
    private final String introduce;
    private final List<String> linkUrl;
    private final Integer feedCount;
    private final Integer followerCount;
    private final Integer followingCount;
}
