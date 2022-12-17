package menu.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.Menu;

class MenuRecommendRepositoryTest {

	@Test
	void addCoachDupMenuErrorTest() {
		Coach coach1 = new Coach("김");
		Coach coach2 = new Coach("이");
		Menu menu1 = new Menu("국밥");
		Menu menu2 = new Menu("깍두기");
		MenuRecommendRepository.addMenuByDayAndCoach(Day.MONDAY, coach1, menu1);
		MenuRecommendRepository.addMenuByDayAndCoach(Day.MONDAY, coach2, menu1);
		MenuRecommendRepository.addMenuByDayAndCoach(Day.TUESDAY, coach1, menu2);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MenuRecommendRepository.addMenuByDayAndCoach(Day.TUESDAY, coach1, menu2);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			MenuRecommendRepository.addMenuByDayAndCoach(Day.FRIDAY, coach1, menu2);
		});
	}

}
