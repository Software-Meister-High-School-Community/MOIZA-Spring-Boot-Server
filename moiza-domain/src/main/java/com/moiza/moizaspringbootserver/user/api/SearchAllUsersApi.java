package com.moiza.moizaspringbootserver.user.api;

import com.moiza.moizaspringbootserver.user.api.dto.response.SearchAllUsersResponse;

public interface SearchAllUsersApi {
    SearchAllUsersResponse execute(String name, Integer page);
}
