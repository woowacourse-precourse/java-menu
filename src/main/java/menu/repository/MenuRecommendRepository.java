package menu.repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.Menu;

public class MenuRecommendRepository {

	private static final int DUP_MAX = 2;

	private static final Map<Day, Category> categoryByDay = new HashMap<>();
	private static final Map<Day, Map<Coach, Menu>> coachMenuByDay = new HashMap<>();

	static {
		initCategoryByDay(Day.from(1));
		initCategoryByDay(Day.from(2));
		initCategoryByDay(Day.from(3));
		initCategoryByDay(Day.from(4));
		initCategoryByDay(Day.from(5));
	}

	public static Map<Day, Category> categoryByDay() {
		return Collections.unmodifiableMap(categoryByDay);
	}

	public static Map<Day, Map<Coach,Menu>> coachMenuByDay() {
		return Collections.unmodifiableMap(coachMenuByDay);
	}

	private static void initCategoryByDay(Day day) {
		Category category;
		int count = 0;
		do {
			category = Category.from(Randoms.pickNumberInRange(1, 5));
			Map<Day, Category> currentCategory = categoryByDay();
			Category finalCategory = category;
			count = (int)currentCategory.values().stream()
				.filter(category1 -> category1.equals(finalCategory))
				.count();
		} while (count >= DUP_MAX);
		categoryByDay.put(day, category);
	}

	public static void addMenuByDayAndCoach(Day day, Coach coach, Menu menu) throws IllegalArgumentException {
		initIfNull(day);
		checkMenuDuplicated(coach, menu);
		coachMenuByDay.get(day).put(coach, menu);
	}

	private static void checkMenuDuplicated(Coach coach, Menu menu) {
		int count = (int)coachMenuByDay.keySet().stream()
			.map(day1 -> coachMenuByDay.get(day1))
			.filter(coachMenuMap -> coachMenuMap.keySet().contains(coach))
			.filter(coachMenuMap -> coachMenuMap.get(coach).equals(menu))
			.count();
		if (count >= 1) {
			throw new IllegalArgumentException("[ERROR] 한 코치에 대한 동일한 메뉴의 입력은 불가합니다.");
		}
	}

	private static void initIfNull(Day day) {
		if (coachMenuByDay.get(day) == null) {
			coachMenuByDay.put(day, new HashMap<>());
		}
	}
}
