package com.moiza.moizaspringbootserver.domain.user.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.domain.user.mapper.UserMapper;
import com.moiza.moizaspringbootserver.user.api.dto.response.SearchAllUsersResponse;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import com.moiza.moizaspringbootserver.user.spi.UserSpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class UserPersistenceAdapter implements UserSpi {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public User getUserByEmail(String email) {
        return userMapper.userEntityToDomain(userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION));
    }

    @Override
    public User queryUserById(UUID userId) {
        return userMapper.userEntityToDomain(
                userRepository.findById(userId)
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION)
        );
    }

    @Override
    public SearchAllUsersResponse querySearchAllUsers(String name, Integer page) {
        return userRepository.querySearchAllUsers(name, page);
    }

    @Override
    public boolean existsUserById(UUID userId) {
        return userRepository.findById(userId).isPresent();
    }

    @Override
    public boolean existsUserByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId).isPresent();
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public String queryGetEmailByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION)
                .getEmail();
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

    @Override
    public void deleteUserById(UUID uuid) {
        userRepository.deleteById(
                userRepository.findById(uuid)
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION)
                        .getId()
        );
    }

    @Override
    public void updateUserIntroduce(UUID uuid, String introduce) {
        UserEntity user = userRepository.findById(uuid)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        user.editIntroduce(introduce);

    }

    @Override
    public void updateUserProfile(UUID uuid, String imageUrl, String backgroundColor) {
        UserEntity user = userRepository.findById(uuid)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        user.editProfileInfo(imageUrl, backgroundColor);
    }
}
