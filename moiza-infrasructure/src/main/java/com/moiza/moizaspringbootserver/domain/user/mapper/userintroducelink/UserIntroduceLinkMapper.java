package com.moiza.moizaspringbootserver.domain.user.mapper.userintroducelink;

import com.moiza.moizaspringbootserver.domain.user.domain.UserIntroduceLinkEntity;
import com.moiza.moizaspringbootserver.user.domain.UserIntroduceLink;

public interface UserIntroduceLinkMapper {
	UserIntroduceLink domainToEntity(UserIntroduceLinkEntity entity);
	UserIntroduceLinkEntity entityToDomain(UserIntroduceLink domain);
}
