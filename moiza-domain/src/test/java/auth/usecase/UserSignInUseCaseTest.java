package auth.usecase;

import static org.mockito.BDDMockito.given;

import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainUserSignInRequest;
import com.moiza.moizaspringbootserver.auth.spi.CommandRefreshTokenSpi;
import com.moiza.moizaspringbootserver.auth.spi.CommandUserDeviceTokenSpi;
import com.moiza.moizaspringbootserver.auth.spi.UserJwtSpi;
import com.moiza.moizaspringbootserver.auth.spi.UserSecuritySpi;
import com.moiza.moizaspringbootserver.auth.spi.dto.TokenResponse;
import com.moiza.moizaspringbootserver.auth.usecase.UserSignInUseCase;
import com.moiza.moizaspringbootserver.user.User;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserSignInUseCaseTest {

	@Mock
	QueryUserSpi queryUserSpi;

	@Mock
	UserSecuritySpi userSecuritySpi;

	@Mock
	UserJwtSpi userJwtSpi;

	@Mock
	CommandUserDeviceTokenSpi commandUserDeviceTokenSpi;

	@Mock
	CommandRefreshTokenSpi commandRefreshTokenSpi;

	@InjectMocks
	UserSignInUseCase userSignInUseCase;

	@Test
	void 로그인() {
		String accountId = "accountId";
		String password = "password";
		String email = "email";
		String token = "token";
		Long exp = (long) 123;
		DomainUserSignInRequest request = DomainUserSignInRequest.builder()
			.accountId(accountId)
			.password(password)
			.build();
		User user = User.builder()
			.password(password)
			.email(email)
			.build();
		TokenResponse tokenResponse = TokenResponse.builder()
			.accessToken(token)
			.refreshToken(token)
			.refreshExp(exp)
			.build();

		given(queryUserSpi.queryUserByAccountId(request.getAccountId()))
			.willReturn(user);
		given(userSecuritySpi.matches(request.getPassword(), user.getPassword()))
			.willReturn(true);
		given(userJwtSpi.getToken(user.getEmail()))
			.willReturn(tokenResponse);
	}
}
