package com.moiza.moizaspringbootserver.user.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.user.api.QueryUserProfileDetailApi;
import com.moiza.moizaspringbootserver.user.api.dto.response.UserProfileDetailsResponse;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import com.moiza.moizaspringbootserver.user.spi.UserIntroduceLinkSpi;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class QueryUserProfileDetailUseCase implements QueryUserProfileDetailApi {

    private final QueryUserSpi queryUserSpi;
    private final UserIntroduceLinkSpi userIntroduceLinkSpi;

    @Override
    public UserProfileDetailsResponse execute(UUID userId) {
        User user = queryUserSpi.queryUserById(userId);
        List<String> userIntroduceLink = userIntroduceLinkSpi.getIntroduceLinkList(userId);

        return UserProfileDetailsResponse.builder()
                .name(user.getName())
                .school(user.getSchool())
                .userScope(user.getUserType())
                .profileImageUrl(user.getProfileImageUrl())
                .profileBackGroundColor(user.getProfileBackgroundColor())
                .introduce(user.getIntroduce())
                .linkUrl(userIntroduceLink)
                .build();
    }
}
