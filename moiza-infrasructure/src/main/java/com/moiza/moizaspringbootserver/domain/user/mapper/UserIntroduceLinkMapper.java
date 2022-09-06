package com.moiza.moizaspringbootserver.domain.user.mapper;

import com.moiza.moizaspringbootserver.domain.user.domain.UserIntroduceLinkEntity;
import com.moiza.moizaspringbootserver.user.UserIntroduceLink;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserIntroduceLinkMapper {
	UserIntroduceLink domainToEntity(UserIntroduceLinkEntity entity);
	UserIntroduceLinkEntity entityToDomain(UserIntroduceLink domain);
}
