package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import index.Init;
import index.WeekendIndex;
import input.Input;
import menu.Category;
import menu.CategoryIndex;
import validation.Validation;
import view.View;

public class Controller {
	public static final String COMMA = ",";
	public static final int MAX_CATEGORY_CHOSEN = 2;
	public static List<String> coachNames;
	public static List<String> hateFoods;
	public static List<List<String>> menuRecommendResult;
	public static List<Integer> categoryCount;
	public static List<String> weeklyCategory;
	public static String recommendMenu;

	public static void programStart() {
		init();
		View.showMenuRecommendGuideMessage();
		selectCoachName();
		createMenuRecommendResult();
		selectHateFoods();
		selectCategories();
		selectMenus();

		showResult();
	}

	private static void showResult() {
		View.showRecommendResult(weeklyCategory, menuRecommendResult);
		View.showRecommendClearGuideMessage();
	}

	private static void selectMenus() {
		for (int weekend = WeekendIndex.START_INDEX.getIndex();
			 weekend < WeekendIndex.END_INDEX.getIndex(); weekend++) {
			String category = weeklyCategory.get(weekend);

			for (int coachIndex = Init.INIT.getIndex(); coachIndex < coachNames.size(); coachIndex++) {
				menuRecommendResult.get(coachIndex).add(selectMenu(hateFoods, coachIndex, category));
			}
		}
	}

	private static void createMenuRecommendResult() {
		for (int coachIndex = Init.INIT.getIndex(); coachIndex < coachNames.size(); coachIndex++) {
			menuRecommendResult.add(new ArrayList<>());
			menuRecommendResult.get(coachIndex).add(coachNames.get(coachIndex));
		}
	}

	private static void selectCoachName() {
		View.showCoachNameGuideMessage();
		String coachNamesInput = Validation.validateCoachInputException(Input.input());
		coachNames = Arrays.asList(coachNamesInput.split(COMMA));
	}

	private static void selectHateFoods() {
		for (String coachName : coachNames) {
			View.showHateFoodGuideMessage(coachName);
			String hateFoodInput = Validation.validateHateFoodInputException(Input.input(), coachName);
			hateFoods = Arrays.asList(hateFoodInput.split(COMMA));
		}
	}

	private static void selectCategories() {
		for (int weekend = WeekendIndex.START_INDEX.getIndex();
			 weekend < WeekendIndex.END_INDEX.getIndex(); weekend++) {
			int categoryNumber = selectCategoryNumber();

			categoryCount.set(categoryNumber, categoryCount.get(categoryNumber) + 1);
			weeklyCategory.add(Category.getCategoryName(categoryNumber));
		}
	}

	private static int selectCategoryNumber() {
		int categoryNumber = Randoms.pickNumberInRange(
			CategoryIndex.MIN_CATEGORY_INDEX.getIndex(), CategoryIndex.MAX_CATEGORY_INDEX.getIndex());

		while (categoryCount.get(categoryNumber) >= MAX_CATEGORY_CHOSEN) {
			categoryNumber = Randoms.pickNumberInRange(CategoryIndex.MIN_CATEGORY_INDEX.getIndex(),
				CategoryIndex.MAX_CATEGORY_INDEX.getIndex());
		}
		return categoryNumber;
	}

	private static String selectMenu(List<String> coachesHateFood, int coachIndex, String category) {
		recommendMenu = Randoms.shuffle(Category.getMenus(category)).get(Init.INIT.getIndex());

		while (coachesHateFood.contains(recommendMenu) || menuRecommendResult.get(coachIndex).contains(recommendMenu)) {
			recommendMenu = Randoms.shuffle(Category.getMenus(category)).get(Init.INIT.getIndex());
		}

		return recommendMenu;
	}

	private static void init() {
		hateFoods = new ArrayList<>();
		weeklyCategory = new ArrayList<>();
		weeklyCategory.add("카테고리");
		menuRecommendResult = new ArrayList<>();
		categoryCount = new ArrayList<>();

		for (int i = Init.INIT.getIndex(); i < Init.INIT_CATEGORY_COUNT_SIZE.getIndex(); i++) {
			categoryCount.add(Init.INIT.getIndex());
		}
	}
}
