package com.moiza.moizaspringbootserver.domain.user.mapper.userintroducelink;

import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.UserIntroduceLinkEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.user.domain.UserIntroduceLink;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserIntroduceMapperImpl implements UserIntroduceLinkMapper {

	private final UserRepository userRepository;

	@Override
	public UserIntroduceLink entityToDomain(UserIntroduceLinkEntity entity) {
		return UserIntroduceLink.builder()
			.id(entity.getId())
			.linkUrl(entity.getLinkUrl())
			.userId(entity.getUserEntity().getId())
			.build();
	}

	@Override
	public UserIntroduceLinkEntity domainToEntity(UserIntroduceLink domain) {
		UserEntity userEntity = userRepository.findById(domain.getUserId())
			.orElseThrow(() -> UserNotFoundException.EXCEPTION);

		return UserIntroduceLinkEntity.builder()
			.id(domain.getId())
			.linkUrl(domain.getLinkUrl())
			.userEntity(userEntity)
			.build();
	}
}
