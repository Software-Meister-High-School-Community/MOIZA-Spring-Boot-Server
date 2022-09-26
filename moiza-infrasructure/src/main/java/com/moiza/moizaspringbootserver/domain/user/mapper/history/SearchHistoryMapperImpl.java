package com.moiza.moizaspringbootserver.domain.user.mapper.history;

import com.moiza.moizaspringbootserver.domain.user.domain.SearchHistoryEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.user.domain.SearchHistory;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SearchHistoryMapperImpl implements SearchHistoryMapper{

    private final UserRepository userRepository;

    @Override
    public SearchHistoryEntity searchHistoryDomainToEntity(SearchHistory searchHistory) {

        UserEntity userEntity = userRepository.findById(searchHistory.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return SearchHistoryEntity.builder()
                .id(searchHistory.getId())
                .createdAt(searchHistory.getCreatedAt())
                .userEntity(userEntity)
                .build();
    }

    @Override
    public SearchHistory searchHistoryEntityToDomain(SearchHistoryEntity searchHistoryEntity) {
        return SearchHistory.builder()
                .id(searchHistoryEntity.getId())
                .createdAt(searchHistoryEntity.getCreatedAt())
                .userId(searchHistoryEntity.getUserEntity().getId())
                .build();
    }
}
