package follow;

import static org.mockito.BDDMockito.given;

import com.moiza.moizaspringbootserver.follow.sqi.CommandFollowSpi;
import com.moiza.moizaspringbootserver.follow.sqi.FollowAuthSecuritySpi;
import com.moiza.moizaspringbootserver.follow.sqi.FollowQueryUserSpi;
import com.moiza.moizaspringbootserver.follow.sqi.QueryFollowSpi;
import com.moiza.moizaspringbootserver.follow.usecase.CancelFollowUseCase;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CancelFollowUseCaseTest {

	@Mock
	FollowQueryUserSpi followQueryUserSpi;

	@Mock
	QueryFollowSpi queryFollowSpi;

	@Mock
	FollowAuthSecuritySpi followAuthSecuritySpi;

	@Mock
	CommandFollowSpi commandFollowSpi;

	@InjectMocks
	CancelFollowUseCase cancelFollowUseCase;

	@Test
	void cancelFollow() {
		UUID userId = UUID.randomUUID();
		cancelFollowUseCase.execute(userId);
	}
}
