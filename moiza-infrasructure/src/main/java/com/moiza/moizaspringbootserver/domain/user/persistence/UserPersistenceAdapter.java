package com.moiza.moizaspringbootserver.domain.user.persistence;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.domain.user.mapper.UserMapper;
import com.moiza.moizaspringbootserver.user.User;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import com.moiza.moizaspringbootserver.user.spi.UserSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class UserPersistenceAdapter implements UserSpi {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Override
	public boolean existsUserByAccountId(String accountId) {
		return userRepository.findByAccountId(accountId).isPresent();
	}

	@Override
	public boolean existsUserByEmail(String email) {
		return userRepository.findByEmail(email).isPresent();
	}

	@Override
	public User queryUserByAccountId(String accountId) {
		return userMapper.userEntityToDomain(
			userRepository.findByAccountId(accountId)
				.orElseThrow(() -> UserNotFoundException.EXCEPTION)
		);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(
			userMapper.userDomainToEntity(user)
		);
	}
}
