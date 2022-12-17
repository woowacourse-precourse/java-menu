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
}
