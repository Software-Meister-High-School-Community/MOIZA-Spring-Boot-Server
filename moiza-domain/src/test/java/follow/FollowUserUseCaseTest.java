package follow;

import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.follow.spi.CommandFollowSpi;
import com.moiza.moizaspringbootserver.follow.spi.FollowQueryUserSpi;
import com.moiza.moizaspringbootserver.follow.usecase.FollowUserUseCase;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FollowUserUseCaseTest {

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
		followUserUseCase.execute(userId);
	}

}
