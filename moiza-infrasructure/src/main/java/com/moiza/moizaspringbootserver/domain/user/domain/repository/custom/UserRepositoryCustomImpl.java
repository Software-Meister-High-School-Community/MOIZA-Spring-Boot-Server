package com.moiza.moizaspringbootserver.domain.user.domain.repository.custom;

import com.moiza.moizaspringbootserver.domain.user.domain.repository.vo.QuerySearchAllUsersVO;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.vo.QQuerySearchAllUsersVO;
import com.moiza.moizaspringbootserver.user.api.dto.response.SearchAllUsersResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.moiza.moizaspringbootserver.domain.user.domain.QUserEntity.userEntity;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public SearchAllUsersResponse querySearchAllUsers(String name, Integer page) {
        long size = 6;

        List<QuerySearchAllUsersVO> query = jpaQueryFactory
                .select(
                        new QQuerySearchAllUsersVO(
                                userEntity.id,
                                userEntity.name,
                                userEntity.profileImageUrl,
                                userEntity.userType,
                                userEntity.school
                        )
                )
                .from(userEntity)
                .where(userEntity.name.contains(name))
                .offset((long) page * size)
                .limit(size)
                .fetch();

        Integer totalPage = query.size();

        List<SearchAllUsersResponse.UserList> resultUsers = query.stream().map(
                it -> SearchAllUsersResponse.UserList.builder()
                        .userId(it.getUserId())
                        .name(it.getName())
                        .profileImageUrl(it.getProfileImageUrl())
                        .userType(it.getUserType())
                        .school(it.getSchool())
                        .build()
        ).collect(Collectors.toList());

        return new SearchAllUsersResponse(resultUsers, totalPage);
    }
}
