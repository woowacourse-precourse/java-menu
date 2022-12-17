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
	List<String> byDayOfTheWeekSelectCategoryRepository = new ArrayList<>();
	Map<String, Integer> countCotegory = new HashMap<>();

	public void programSetting() {
		menuMapping();
		setCountCotegory();
	}

	public void menuMapping() {
		category.settingCategorys();
		menu.settingMenu();
		for (int index = 0; index < category.getCategoriesCount(); index++) {
			totelMenu.settingTotelMenus(category.getCategory(index), menu.getMenus(index));
		}
	}

	public void setCountCotegory() {
		for (int index = 0; index < category.getCategoriesCount(); index++) {
			countCotegory.put(category.getCategory(index), 0);
		}
	}


	public void byDayOfTheWeekSelectCategory() {
		while (countSelect() != 5) {
			String selectCategory = category.getCategory(Randoms.pickNumberInRange(1, 5));
			judgmentCotegotyAdd(selectCategory);
		}
	}

	public void judgmentCotegotyAdd(String selectCategory) {
		if (countCotegory.get(selectCategory) < 2)
			byDayOfTheWeekSelectCategoryRepository.add(selectCategory);
	}





	public int countSelect() {
		int count = 0;
		for (int countValue : countCotegory.values())
			count += countValue;
		return count;
	}

}