package follow;

import static org.mockito.BDDMockito.given;

import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.follow.sqi.CommandFollowSpi;
import com.moiza.moizaspringbootserver.follow.sqi.FollowQueryUserSpi;
import com.moiza.moizaspringbootserver.follow.usecase.FollowUserUseCase;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FollowUserUseCaseTest {

	@Mock
	FollowQueryUserSpi followQueryUserSpi;

	@Mock
	AuthSecuritySpi authSecuritySpi;

	@Mock
	CommandFollowSpi commandFollowSpi;

	@InjectMocks
	FollowUserUseCase followUserUseCase;

	@Test
	void followUser() {
		UUID userId = UUID.randomUUID();
		UUID currentUserId = UUID.randomUUID();

		given(authSecuritySpi.getCurrentUserId())
			.willReturn(currentUserId);

		followUserUseCase.execute(userId);
	}

}
