package follow;

import com.moiza.moizaspringbootserver.follow.sqi.CommandFollowSpi;
import com.moiza.moizaspringbootserver.follow.sqi.FollowAuthSecuritySpi;
import com.moiza.moizaspringbootserver.follow.sqi.FollowQueryUserSpi;
import com.moiza.moizaspringbootserver.follow.sqi.QueryFollowSpi;
import com.moiza.moizaspringbootserver.follow.usecase.DeleteFollowUseCase;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteFollowUseCaseTest {

	@Mock
	FollowAuthSecuritySpi followAuthSecuritySpi;

	@Mock
	FollowQueryUserSpi followQueryUserSpi;

	@Mock
	CommandFollowSpi commandFollowSpi;

	@Mock
	QueryFollowSpi queryFollowSpi;

	@InjectMocks
	DeleteFollowUseCase deleteFollowUseCase;

	@Test
	void deleteFollow() {
		UUID userId = UUID.randomUUID();

		deleteFollowUseCase.execute(userId);
	}
}
