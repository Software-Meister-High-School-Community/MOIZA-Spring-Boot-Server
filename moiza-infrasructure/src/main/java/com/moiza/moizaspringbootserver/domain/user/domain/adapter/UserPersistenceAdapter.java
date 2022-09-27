package com.moiza.moizaspringbootserver.domain.user.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.domain.user.mapper.UserMapper;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import com.moiza.moizaspringbootserver.user.exception.UserQueryFailedException;
import com.moiza.moizaspringbootserver.user.spi.UserSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

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
    public User queryCurrentUser() {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return getUserByEmail(userDetails.getUsername());
        } catch (NullPointerException exception) {
            throw UserQueryFailedException.EXCEPTION;
        }
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
    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }
}
