package com.moiza.moizaspringbootserver.user.api.dto.response;

import com.moiza.moizaspringbootserver.user.domain.enums.School;
import com.moiza.moizaspringbootserver.user.domain.enums.UserType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class MyPageResponse {
    private final UUID userId;
    private final String name;
    private final School school;
    private final UserType userScope;
    private final String profileImageUrl;
    private final String profileBackgroundColor;
    private final String introduce;
    private final List<String> linkUrl;
    private final Long feedCount;
    private final Long followerCount;
    private final Long followingCount;
}
