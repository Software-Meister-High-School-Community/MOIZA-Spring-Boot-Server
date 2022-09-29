package user.usecase;

import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.user.api.QueryUserProfileDetailApi;
import com.moiza.moizaspringbootserver.user.domain.UserIntroduceLink;
import com.moiza.moizaspringbootserver.user.spi.UserQueryIntroduceLinkSpi;
import com.moiza.moizaspringbootserver.user.usecase.QueryUserProfileDetailUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserIntroduceLinkUseCaseTest {

    @Mock
    AuthSecuritySpi authSecuritySpi;

    @Mock
    UserQueryIntroduceLinkSpi userQueryIntroduceLinkSpi;

    @Mock
    QueryUserProfileDetailUseCase queryUserProfileDetailUseCase;

    @Test
    void 프로필_보기() {
        UUID userId = UUID.randomUUID();
        List<String> introduceLink = Collections.singletonList("https://~~~");

        given(authSecuritySpi.getCurrentUserId())
                .willReturn(userId);


        given(userQueryIntroduceLinkSpi.getIntroduceLinkList(userId))
                .willReturn(introduceLink);

        queryUserProfileDetailUseCase.execute(userId);
    }
}
