package menu.domain;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import javax.imageio.stream.ImageInputStream;

import camp.nextstep.edu.missionutils.Randoms;
import menu.utils.ErrorMessage;

public class WeeklyMenu {

	private static final List<Category> categories = List.of(Category.JAPANESE, Category.KOREAN, Category.CHINESE,
		Category.ASIAN, Category.WESTERN);

	private List<Category> recommendation;

	public WeeklyMenu() {
		recommendation = setRecommendMenu();
	}

	public List<Category> getRecommendation() {
		return recommendation;
	}

	public String getWeeklyMenuResult() {
		StringBuilder stringBuilder = new StringBuilder();
		recommendation.forEach(category -> stringBuilder.append(String.format("| %s ", category.getName())));
		return stringBuilder.toString();
	}

	private List<Category> setRecommendMenu() {
		try {
			return recommendMenu();
		} catch (IllegalStateException e) {
			return setRecommendMenu();
		}
	}

	private List<Category> recommendMenu() {
		List<Category> recommendMenu = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Category category = categories.get(Randoms.pickNumberInRange(1, 5) - 1);
			recommendMenu.add(category);
		}
		validateDuplicate(recommendMenu);
		return recommendMenu;
	}

	private void validateDuplicate(List<Category> recommendMenu) {
		HashMap<Category, Integer> duplicate = new HashMap<>();
		recommendMenu.forEach(category -> duplicate.put(category, duplicate.getOrDefault(category, 0) + 1));
		for (Category category : duplicate.keySet()) {
			if (duplicate.get(category) > 2) {
				throw new IllegalStateException(ErrorMessage.CATEGORY.getMessage());
			}
		}
	}

}
