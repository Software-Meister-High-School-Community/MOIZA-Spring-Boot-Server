package com.moiza.moizaspringbootserver.domain.user.domain.repository.custom;

import com.moiza.moizaspringbootserver.user.api.dto.response.SearchAllUsersResponse;

public interface UserRepositoryCustom {
    SearchAllUsersResponse querySearchAllUsers(String name, Integer page);
}
