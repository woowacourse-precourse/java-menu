package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Service {

	Category category = new Category();
	Menu menu = new Menu();
	TotelMenu totelMenu = new TotelMenu();
	InputView inputView = new InputView();
	CoachRepository coachRepository = new CoachRepository();
	List<String> byDayOfTheWeekSelectCategoryRepository = new ArrayList<>();
	Coach coach = new Coach();
	OutputView outputView = new OutputView();
	Map<String, Integer> countCotegory = new HashMap<>();

	Map<String, List<String>> perCoachRecommendMenu = new HashMap<>();

	public void programSetting() {
		menuMapping();
		setCountCotegory();
		byDayOfTheWeekSelectCategory();
	}

	public void menuMapping() {
		category.settingCategorys();
		menu.settingMenu();
		for (int index = 0; index < category.getCategoriesCount(); index++) {
			totelMenu.settingTotelMenus(category.getCategory(index), menu.getTotelMenus(index));
		}
	}

	public void setCountCotegory() {
		for (int index = 0; index < category.getCategoriesCount(); index++) {
			countCotegory.put(category.getCategory(index), 0);
		}
	}

	public void byDayOfTheWeekSelectCategory() {
		while (countSelect() != 5) {
			String selectCategory = category.getCategory(Randoms.pickNumberInRange(0, 4));
			judgmentCotegotyAdd(selectCategory);
		}
	}

	public void judgmentCotegotyAdd(String selectCategory) {
		if (countCotegory.get(selectCategory) < 2) {
			countCotegory.put(selectCategory, countCotegory.get(selectCategory) + 1);
			byDayOfTheWeekSelectCategoryRepository.add(selectCategory);
		}
	}

	public int countSelect() {
		int count = 0;
		for (int countValue : countCotegory.values())
			count += countValue;
		return count;
	}

	public void recommendProgram() {
		saveCoachs();
		selectMenu();
		outputView.resultMessage();
		outputView.resultCategory(byDayOfTheWeekSelectCategoryRepository);
		printSelectMenu();
	}

	public void saveCoachs() {
		List<String> inputCoachs = checkInputCoach();
		for (String inputCoach : inputCoachs) {
			List<String> inputNotEatFoods = checkInputNotEatFood(inputCoach);
			coachRepository.setCoachs(inputCoach, inputNotEatFoods);
		}
		coach.setCoachsName(inputCoachs);
	}

	public void selectMenu() {
		for (String category : byDayOfTheWeekSelectCategoryRepository) {
			List<String> categoryMenu = totelMenu.getCategoryMenu(category);
			for (int index = 0; index < coachRepository.getCoachsSize(); index++) {
				notEatFoodsRemove(coach.getCoachsName(index), categoryMenu);
			}
		}
	}

	public void notEatFoodsRemove(String coachName, List<String> categoryMenu) {
		for (int index = 0; index <  coachRepository.getCoachsSize(); index++) {
			String menu = Randoms.shuffle(categoryMenu).get(0);
			if (coachRepository.discriminationEat(menu, coachName)) {
				perCoachRecommendMenu.put(coachName, new ArrayList<>());
			}
		}
	}

	public void printSelectMenu() {
		for (int index = 0; index < perCoachRecommendMenu.size(); index++) {
			outputView.resultMenu(coach.getCoachsName(index), perCoachRecommendMenu.get(coach.getCoachsName(index)));
		}
	}
	private List<String> checkInputCoach() {
		try {
			outputView.coachInputMessage();
			return inputView.readInputCoachs();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return checkInputCoach();
		}
	}
	private List<String> checkInputNotEatFood(String coachName) {
		try {
			outputView.notEatFoodMessage(coachName);
			return inputView.readNotEatFood();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return checkInputNotEatFood(coachName);
		}
	}

}