package com.moiza.moizaspringbootserver.domain.user.persistence;

import com.moiza.moizaspringbootserver.auth.spi.UserDeviceTokenSpi;
import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserDeviceTokenRepository;
import com.moiza.moizaspringbootserver.domain.user.mapper.userdevicetoken.UserDeviceTokenMapper;
import com.moiza.moizaspringbootserver.user.UserDeviceToken;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class UserDeviceTokenPersistenceAdapter implements UserDeviceTokenSpi {

	private final UserDeviceTokenRepository userDeviceTokenRepository;
	private final UserDeviceTokenMapper userDeviceTokenMapper;

	@Override
	public void saveUserDeviceToken(UserDeviceToken userDeviceToken) {
		userDeviceTokenRepository.save(
			userDeviceTokenMapper.userDeviceTokenDomainToEntity(userDeviceToken)
		);
	}
}
