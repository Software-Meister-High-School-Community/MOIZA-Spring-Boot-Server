package com.moiza.moizaspringbootserver.user.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.user.api.UserEditApi;
import com.moiza.moizaspringbootserver.user.api.dto.request.DomainUserEditRequest;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.spi.CommandUserSpi;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import com.moiza.moizaspringbootserver.user.spi.UserIntroduceLinkSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UserEditUseCase implements UserEditApi {
    private final QueryUserSpi queryUserSpi;
    private final CommandUserSpi commandUserSpi;
    private final UserIntroduceLinkSpi userIntroduceLinkSpi;
    private final AuthSecuritySpi authSecuritySpi;


    @Override
    public void execute(DomainUserEditRequest request) {
        User user = queryUserSpi.queryUserById(authSecuritySpi.getCurrentUserId());

        commandUserSpi.updateUserIntroduce(user.getId(), request.getIntroduce());
        commandUserSpi.updateUserProfile(user.getId(), request.getProfileImageUrl(), request.getProfileBackgroundColor());
        userIntroduceLinkSpi.updateLinksByUserId(user.getId(), request.getIntroduceLinkUrl());
    }
}
