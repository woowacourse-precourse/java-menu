package menu.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import menu.domain.Coach;
import menu.domain.Menu;

class CoachUnableMenuRepositoryTest {

	@Test
	void unableMenuAddGetTest() {
		CoachUnableMenuRepository coachUnableMenuRepository = new CoachUnableMenuRepository();
		Coach coach = new Coach("가");
		Menu unableMenu = new Menu("김치");

		CoachUnableMenuRepository.addUnableMenuByCoach(coach, unableMenu);
		List<Menu> unableOf가 = 	CoachUnableMenuRepository.getUnableByCoach(coach);
		Assertions.assertThat(unableOf가).contains(unableMenu);
	}
}
