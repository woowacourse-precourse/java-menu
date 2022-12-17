package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import input.Input;
import menu.Category;
import menu.CategoryIndex;
import validation.Validation;
import view.View;

public class Controller {
	public static List<String> coachNames; //이거 리스트로 바꿔 그리고 이넘 사용 고려해봐
	public static List<String> hateFoods;
	public static List<String> coachesHateFood;
	public static List<List<String>> menuRecommendResult;
	public static String recommendMenu;
	public static List<Integer> categoryCount;
	public static List<String> weeklyCategory;

	public static void programStart() {
		init();
		View.showMenuRecommendGuideMessage();
		selectCoachName();
		createMenuRecommendResult();
		selectHateFoods();
		selectCategories();
		selectMenues();

		showResult();
	}

	private static void showResult() {
		View.showRecommendResult(weeklyCategory, menuRecommendResult);
		View.showRecommendClearGuideMessage();
	}

	private static void selectMenues() {
		for (int weekend = 0; weekend < 5; weekend++) {
			String category = weeklyCategory.get(weekend);

			for (int coachIndex = 0; coachIndex < coachNames.size(); coachIndex++) {
				menuRecommendResult.get(coachIndex).add(selectMenu(coachesHateFood, coachIndex, category));
			}
		}
	}

	private static void createMenuRecommendResult() {
		for (int coachIndex = 0; coachIndex < coachNames.size(); coachIndex++) {
			menuRecommendResult.add(new ArrayList<>());
			menuRecommendResult.get(coachIndex).add(coachNames.get(coachIndex));
		}
	}

	private static void selectCoachName() {
		View.showCoachNameGuideMessage();
		String coachNamesInput = Validation.validateCoachInputException(Input.input());
		coachNames = Arrays.asList(coachNamesInput.split(","));
	}

	private static void selectHateFoods() {
		for (String coachName : coachNames) {
			View.showHateFoodGuideMessage(coachName);
			String hateFoodInput = Validation.validateHateFoodInputException(Input.input(), coachName);
			hateFoods = Arrays.asList(hateFoodInput.split(","));

			for (String hateFood : hateFoods) {
				coachesHateFood.add(hateFood);
			}
		}
	}

	private static void selectCategories() {
		for (int weekend = 0; weekend < 5; weekend++) {
			int categoryNumber = selectCategoryNumber();

			categoryCount.set(categoryNumber, categoryCount.get(categoryNumber) + 1);
			weeklyCategory.add(Category.getCategoryName(categoryNumber));
		}
	}

	private static int selectCategoryNumber() {
		int categoryNumber = Randoms.pickNumberInRange(
			CategoryIndex.MIN_CATEGORY_INDEX.getIndex(), CategoryIndex.MAX_CATEGORY_INDEX.getIndex());

		//한 주에 같은 카테고리는 최대 2회까지만 고를 수 있다.
		while (categoryCount.get(categoryNumber) >= 2) {
			categoryNumber = Randoms.pickNumberInRange(CategoryIndex.MIN_CATEGORY_INDEX.getIndex(), CategoryIndex.MAX_CATEGORY_INDEX.getIndex());
		}
		return categoryNumber;
	}

	private static String selectMenu(List<String> coachesHateFood, int coachIndex, String category) {
		recommendMenu = Randoms.shuffle(Category.getMenus(category)).get(0);

		while (coachesHateFood.contains(recommendMenu) || menuRecommendResult.get(coachIndex).contains(recommendMenu)) {
			recommendMenu = Randoms.shuffle(Category.getMenus(category)).get(0);
		}

		return recommendMenu;
	}

	private static void init() {
		coachesHateFood = new ArrayList<>();
		weeklyCategory = new ArrayList<>();
		weeklyCategory.add("카테고리");

		menuRecommendResult = new ArrayList<>();

		categoryCount = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			categoryCount.add(0);
		}
	}
}
