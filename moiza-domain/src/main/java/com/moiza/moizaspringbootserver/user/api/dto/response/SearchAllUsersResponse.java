package com.moiza.moizaspringbootserver.user.api.dto.response;

import com.moiza.moizaspringbootserver.user.domain.enums.School;
import com.moiza.moizaspringbootserver.user.domain.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class SearchAllUsersResponse {

    private final List<UserList> usersList;
    private final Integer totalPage;

    @Builder
    public static final class UserList {

        private final UUID userId;
        private final String name;
        private final String profileImageUrl;
        private final UserType userType;
        private final School school;
    }
}
