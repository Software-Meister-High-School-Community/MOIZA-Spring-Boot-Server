package com.moiza.moizaspringbootserver.domain.follow.mapper;

import com.moiza.moizaspringbootserver.domain.follow.domain.FollowEntity;
import com.moiza.moizaspringbootserver.follow.Follow;

public interface FollowMapper {
    FollowEntity followDomainToEntity(Follow follow);
    Follow followEntityToDomain(FollowEntity followEntity);
}
