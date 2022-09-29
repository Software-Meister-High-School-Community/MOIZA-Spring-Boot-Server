package com.moiza.moizaspringbootserver.user.api;

import com.moiza.moizaspringbootserver.user.api.dto.response.UserProfileDetailsResponse;

import java.util.UUID;

public interface QueryUserProfileDetailApi {
    UserProfileDetailsResponse execute(UUID userId);
}
