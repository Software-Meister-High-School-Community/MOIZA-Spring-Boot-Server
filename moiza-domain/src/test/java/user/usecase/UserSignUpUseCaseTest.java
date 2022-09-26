package user.usecase;

import static org.mockito.BDDMockito.given;

import com.moiza.moizaspringbootserver.user.api.dto.request.DomainUserSignUpRequest;
import com.moiza.moizaspringbootserver.user.spi.CommandUserSpi;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import com.moiza.moizaspringbootserver.user.spi.UserQueryEmailCodeSpi;
import com.moiza.moizaspringbootserver.user.usecase.UserSignUpUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserSignUpUseCaseTest {

	@Mock
	QueryUserSpi queryUserSpi;

	@Mock
	UserQueryEmailCodeSpi userQueryEmailCodeSpi;

	@Mock
	CommandUserSpi commandUserSpi;

	@InjectMocks
	UserSignUpUseCase userSignUpUseCase;

	@Test
	void userSignUp() {
		String accountId = "accountId";
		String email = "email";

		DomainUserSignUpRequest request = DomainUserSignUpRequest.builder()
			.accountId(accountId)
			.email(email)
			.build();

		given(queryUserSpi.existsUserByAccountId(accountId))
			.willReturn(false);
		given(queryUserSpi.existsUserByEmail(email))
			.willReturn(false);
		given(userQueryEmailCodeSpi.queryEmailCodeById(email))
			.willReturn(
				EmailCode.builder()
					.isVerify(true)
					.build()
			);

		userSignUpUseCase.execute(request);
	}
}
