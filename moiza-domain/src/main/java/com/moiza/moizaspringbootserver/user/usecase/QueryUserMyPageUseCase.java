package com.moiza.moizaspringbootserver.user.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.spi.feed.QueryFeedSpi;
import com.moiza.moizaspringbootserver.follow.spi.QueryFollowSpi;
import com.moiza.moizaspringbootserver.user.api.QueryUserMyPageApi;
import com.moiza.moizaspringbootserver.user.api.dto.response.MyPageResponse;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import com.moiza.moizaspringbootserver.user.spi.UserIntroduceLinkSpi;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class QueryUserMyPageUseCase implements QueryUserMyPageApi {

    private final AuthSecuritySpi authSecuritySpi;
    private final QueryUserSpi queryUserSpi;
    private final UserIntroduceLinkSpi userIntroduceLinkSpi;
    private final QueryFeedSpi queryFeedSpi;
    private final QueryFollowSpi queryFollowSpi;

    @Override
    public MyPageResponse execute() {
        User user = queryUserSpi.queryUserById(authSecuritySpi.getCurrentUserId());
        List<String> userIntroduceLink = userIntroduceLinkSpi.getIntroduceLinkList(user.getId());
        Long feedCount = queryFeedSpi.getUserFeeCount(user);
        Long followCount = queryFollowSpi.getFollowCount(user);

        return MyPageResponse.builder()
                .userId(user.getId())
                .name(user.getName())
                .school(user.getSchool())
                .userScope(user.getUserType())
                .profileImageUrl(user.getProfileImageUrl())
                .profileBackgroundColor(user.getProfileBackgroundColor())
                .linkUrl(userIntroduceLink)
                .feedCount(feedCount)
                .followerCount(followCount)
                .followingCount(followCount)
                .build();
    }
}
