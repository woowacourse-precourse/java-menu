package menu.repository;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;

public class MenuRepository {

	private static final MenuRepository instance = new MenuRepository();

	private MenuRepository() {
	}

	public static MenuRepository getInstance() {
		return instance;
	}

	public Category getRandomCategory() {
		return Category.getCategory(Randoms.pickNumberInRange(1, 5));
	}

	public String getRandomMenuInCategory(Category category) {
		return Randoms.shuffle(category.getMenus()).get(0);
	}

}
