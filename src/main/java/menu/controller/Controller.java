package menu.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;
import menu.model.Coaches;
import menu.model.Menu;
import menu.model.MenuList;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {

	private Coaches coaches;
	private Menu menu;
	private MenuList menusCantEat;
	private InputView inputView;
	private Category category;
	private int japanCount = 0;
	private int koreanCount = 0;
	private int chineseCount = 0;
	private int asianCount = 0;
	private int westernCount = 0;

	public Controller() {
		this.inputView = new InputView();
		this.menusCantEat = new MenuList();
		this.category = new Category();
	}

	public void run() {
		OutputView.printStartMessage();
		coaches = setCoachesName();
		menusCantEat = setMenusCantEat();
		OutputView.printResult();
		logic();
		OutputView.printEndMessage();
	}

	private void logic() {
		for (int i = 0; i < coaches.getNames().size(); i++) {
			String result = "[ " + coaches.getNames().get(i);
			Menu dislikeMenus = menusCantEat.getMenusCantEat().get(i);
			for (int j = 0; j < 5; j++) {
				result += " | " + recommendMenu(dislikeMenus, result);
			}
			result += " ]";
			System.out.println(result);
			resetCounts();
		}
	}

	private void resetCounts() {
		this.japanCount = 0;
		this.koreanCount = 0;
		this.chineseCount = 0;
		this.asianCount = 0;
		this.westernCount = 0;
	}

	private String recommendMenu(Menu menu, String result) {
		int categorySelect = Randoms.pickNumberInRange(1, 5);
		return pickMenu(menu, result, categorySelect);
	}

	private String pickMenu(Menu menu, String result, int categorySelect) {
		if (categorySelect == 1) {
			return recommendJapaneseMenu(menu, result);
		}
		if (categorySelect == 2) {
			return recommendKoreanMenu(menu, result);
		}
		if (categorySelect == 3) {
			return recommendChineseMenu(menu, result);
		}
		if (categorySelect == 4) {
			return recommendAsianMenu(menu, result);
		}
		if (categorySelect == 5) {
			return recommendWesternMenu(menu, result);
		}
		return null;
	}

	private List<String> deleteMenuCantEat(Menu menu, List<String> recommendMenus) {
		List<String> result = recommendMenus;
		for (String menuName : menu.getMenus()) {
			result.remove(menuName);
		}
		return result;
	}

	private String recommendOtherMenu(Menu menu, String result, int except) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			numbers.add(i+1);
		}
		numbers.remove(except);
		Collections.shuffle(numbers);
		int num = numbers.get(0);
		return pickMenu(menu, result, num);
	}

	private String recommendJapaneseMenu(Menu menu, String result) {
		if (japanCount > 1) {
			recommendOtherMenu(menu, result, 1);
		}
		List<String> recommendMenus = deleteMenuCantEat(menu, category.getJapaneseMenu());
		String recommendedMenu = Randoms.shuffle(recommendMenus).get(0);
		if (result.contains(recommendedMenu)) {
			recommendMenus.remove(recommendedMenu);
			return Randoms.shuffle(recommendMenus).get(0);
		}
		japanCount++;
		return recommendedMenu;
	}

	private String recommendKoreanMenu(Menu menu, String result) {
		if (koreanCount > 1) {
			recommendOtherMenu(menu, result, 2);
		}
		List<String> recommendMenus = deleteMenuCantEat(menu, category.getKoreanMenu());
		String recommendedMenu = Randoms.shuffle(recommendMenus).get(0);
		if (result.contains(recommendedMenu)) {
			recommendMenus.remove(recommendedMenu);
			return Randoms.shuffle(recommendMenus).get(0);
		}
		koreanCount++;
		return recommendedMenu;
	}

	private String recommendChineseMenu(Menu menu, String result) {
		if (chineseCount > 1) {
			recommendOtherMenu(menu, result, 3);
		}
		List<String> recommendMenus = deleteMenuCantEat(menu, category.getChineseMenu());
		String recommendedMenu = Randoms.shuffle(recommendMenus).get(0);
		if (result.contains(recommendedMenu)) {
			recommendMenus.remove(recommendedMenu);
			return Randoms.shuffle(recommendMenus).get(0);
		}
		chineseCount++;
		return recommendedMenu;
	}

	private String recommendAsianMenu(Menu menu, String result) {
		if (asianCount > 1) {
			recommendOtherMenu(menu, result, 4);
		}
		List<String> recommendMenus = deleteMenuCantEat(menu, category.getAsianMenu());
		String recommendedMenu = Randoms.shuffle(recommendMenus).get(0);
		if (result.contains(recommendedMenu)) {
			recommendMenus.remove(recommendedMenu);
			return Randoms.shuffle(recommendMenus).get(0);
		}
		asianCount++;
		return recommendedMenu;
	}

	private String recommendWesternMenu(Menu menu, String result) {
		if (westernCount > 1) {
			recommendOtherMenu(menu, result, 5);
		}
		List<String> recommendMenus = deleteMenuCantEat(menu, category.getWesternMenu());
		String recommendedMenu = Randoms.shuffle(recommendMenus).get(0);
		if (result.contains(recommendedMenu)) {
			recommendMenus.remove(recommendedMenu);
			return Randoms.shuffle(recommendMenus).get(0);
		}
		westernCount++;
		return recommendedMenu;
	}

	private Coaches setCoachesName() {
		OutputView.printCoachNameInputMessage();
		List<String> names = inputView.inputCoaches();
		return new Coaches(names);
	}

	private MenuList setMenusCantEat() {
		for (int i = 0; i < coaches.getNames().size(); i++) {
			OutputView.printMenuInputMessage(coaches.getNames().get(i));
			List<String> menuNames = inputView.inputMenuCantEat();
			menusCantEat.getMenusCantEat().add(new Menu(menuNames));
		}
		return menusCantEat;
	}
}
