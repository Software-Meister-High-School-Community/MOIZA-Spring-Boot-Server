package com.moiza.moizaspringbootserver.domain.user.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.user.domain.UserIntroduceLinkEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserIntroduceLinkRepository;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import com.moiza.moizaspringbootserver.user.spi.UserIntroduceLinkSpi;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Adapter
public class UserIntroduceLinkPersistenceAdapter implements UserIntroduceLinkSpi {

    private final UserRepository userRepository;
    private final UserIntroduceLinkRepository userIntroduceLinkRepository;

    @Override
    public List<String> getIntroduceLinkList(UUID userId) {

        List<UserIntroduceLinkEntity> userIntroduceLinks = userIntroduceLinkRepository.findAllByUserEntityId(userId);

        return userIntroduceLinks
                .stream()
                .map(UserIntroduceLinkEntity::getLinkUrl)
                .collect(Collectors.toList());
    }

    @Override
    public void updateLinksByUserId(UUID id, List<String> links) {
        List<UserIntroduceLinkEntity> linkEntities = links.stream()
                .map(link -> UserIntroduceLinkEntity.builder()
                        .id(UUID.randomUUID())
                        .userEntity(userRepository.findById(id).orElseThrow(() -> UserNotFoundException.EXCEPTION))
                        .linkUrl(link)
                        .build())
                .collect(Collectors.toList());

        userIntroduceLinkRepository.saveAll(linkEntities);
    }
}
