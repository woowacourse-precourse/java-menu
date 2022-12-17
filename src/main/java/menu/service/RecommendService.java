package menu.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.Menu;
import menu.repository.CoachUnableMenuRepository;
import menu.repository.MenuRecommendRepository;
import menu.repository.MenuRepository;

public class RecommendService {

	private final Map<Category, List<Menu>> menus = MenuRepository.menus();
	private final List<Coach> coaches;

	public RecommendService(List<Coach> coaches) {
		this.coaches = coaches;
	}

	public void recommend() {
		List<Day> allDays = Day.getAllDays();
		for (Day day : allDays) {
			recommendDay(day);
		}
	}

	public void recommendDay(Day day) {
		Category categoryToday = MenuRecommendRepository.categoryByDay().get(day);
		List<String> menus = this.menus.get(categoryToday).stream()
			.map(menu -> menu.getName())
			.collect(Collectors.toList());
		while(true) {
			try {
				recommendMenu(day, menus);
				return;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void recommendMenu(Day day, List<String> menus) {
		for (Coach coach : coaches) {
			String menu = Randoms.shuffle(menus).get(0);
			Menu chosenMenu = MenuRepository.getMenu(menu);
			isMenuEatable(coach, chosenMenu);
			MenuRecommendRepository.addMenuByDayAndCoach(day, coach, chosenMenu);
		}
	}

	private static void isMenuEatable(Coach coach, Menu chosenMenu) {
		if (!CoachUnableMenuRepository.canCoachEat(coach, chosenMenu)) {
			throw new IllegalArgumentException("[ERROR] 코치가 못 먹는 메뉴입니다.");
		}
	}
}
