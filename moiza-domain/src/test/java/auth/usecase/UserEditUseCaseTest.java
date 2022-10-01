package auth.usecase;

import com.moiza.moizaspringbootserver.auth.exception.UserAuthQueryFailedException;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.user.api.dto.request.DomainUserEditRequest;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.spi.CommandUserSpi;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import com.moiza.moizaspringbootserver.user.spi.UserIntroduceLinkSpi;
import com.moiza.moizaspringbootserver.user.usecase.UserEditUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserEditUseCaseTest {

    @Mock
    QueryUserSpi queryUserSpi;

    @Mock
    CommandUserSpi commandUserSpi;

    @Mock
    UserIntroduceLinkSpi userIntroduceLinkSpi;

    @Mock
    AuthSecuritySpi authSecuritySpi;

    @InjectMocks
    UserEditUseCase userEditUseCase;

    @Test
    void 수정실패_유저조회_불가() {
        DomainUserEditRequest request = DomainUserEditRequest.builder()
                .introduce("인사말")
                .introduceLinkUrl(List.of("link1", "link2"))
                .profileImageUrl("profileImage")
                .profileBackgroundColor("#00498c")
                .build();

        given(authSecuritySpi.getCurrentUserId()).willThrow(UserAuthQueryFailedException.class);

        assertThrows(UserAuthQueryFailedException.class, () -> userEditUseCase.execute(request));
    }

    @Test
    void 수정성공() {
        DomainUserEditRequest request = DomainUserEditRequest.builder()
                .introduce("인사말")
                .introduceLinkUrl(List.of("link1", "link2"))
                .profileImageUrl("profileImage")
                .profileBackgroundColor("#00498c")
                .build();

        UUID uuid = UUID.randomUUID();
        User user = User.builder()
                .id(uuid)
                .build();

        given(authSecuritySpi.getCurrentUserId()).willReturn(uuid);
        given(queryUserSpi.queryUserById(uuid)).willReturn(user);

        userEditUseCase.execute(request);
    }
}
