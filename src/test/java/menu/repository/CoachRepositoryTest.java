package menu.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import menu.domain.Coach;

class CoachRepositoryTest {

	@Test
	void repoAddAndGetCoachTest() {
		CoachRepository coachRepository = new CoachRepository();
		Coach tomy = new Coach("토미");

		CoachRepository.addCoach(tomy);
		Coach foundTomy = CoachRepository.getCoach("토미");

		Assertions.assertThat(tomy.equals(foundTomy));
	}
}
