package user.usecase;

import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.user.api.dto.response.UserSearchHistoryResponse;
import com.moiza.moizaspringbootserver.user.domain.SearchHistory;
import com.moiza.moizaspringbootserver.user.spi.QuerySearchHistorySpi;
import com.moiza.moizaspringbootserver.user.usecase.UserSearchHistoryUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class UserSearchHistoryUseCaseTest {

    @Mock
    AuthSecuritySpi authSecuritySpi;

    @Mock
    QuerySearchHistorySpi querySearchHistorySpi;

    @InjectMocks
    UserSearchHistoryUseCase userSearchHistoryUseCase;

    @Test
    void 유저_검색기록() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        String keyword = "키워드";

        given(authSecuritySpi.getCurrentUserId())
                .willReturn(userId);

        given(querySearchHistorySpi.querySearchHistoryAllByUserId(userId))
                .willReturn(
                        List.of(
                                SearchHistory.builder()
                                        .id(id)
                                        .userId(userId)
                                        .keyword(keyword)
                                        .build()
                        )
                );

        userSearchHistoryUseCase.execute();
    }
}
