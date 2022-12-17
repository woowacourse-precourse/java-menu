package menu.domain.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.category.Category;
import menu.domain.category.Categorys;
import menu.domain.coach.Coach;
import menu.domain.coach.Coachs;
import menu.domain.util.MenuRandomNumberGenerator;

public class MenuGame {

	private static final int MAX_STAGE_INDEX = 5;

	Categorys categorys = new Categorys();

	Coachs coachs = new Coachs();

	MenuRandomNumberGenerator menuRandomNumberGenerator = new MenuRandomNumberGenerator();

	public Coachs insertCoaches(String coaches) {
		coachs.insertCoach(coaches);
		return coachs;
	}

	public void insertNotPossibleMenu(Coach coach, String foods) {
		coach.addNotAllowedFood(foods);
	}

	public void menuRecommand() {
		int index = 0;
		while (index < MAX_STAGE_INDEX) {
			Category category = selectCategory();
			recommendMenuToAllCoaches(category);
			index++;
		}
	}

	public int randomNumber() {
		return menuRandomNumberGenerator.generate();
	}


	public Category selectCategory() {
		while (true) {
			int index = randomNumber();
			Category category = Category.findCategoryNameByIndex(index);
			if (categorys.canAddCategory(category)) {
				categorys.insertCategory(category);
				return category;
			}
		}
	}

	public void recommendMenuToAllCoaches(Category category) {
		List<String> foods = getMenusByCategory(category);
		for (Coach coach : coachs.getCoaches()) {
			String menu = getRandomMenu(foods);
			while (coach.hasMenu(menu)) {
				menu = getRandomMenu(foods);
			}
			coach.addFood(menu);
		}
	}

	public List<String> getMenusByCategory(Category category) {
		List<String> foods = category.getFoodsByCategory(category);
		return foods;
	}

	public String getRandomMenu(List<String> foods) {
		return Randoms.shuffle(foods).get(0);
	}

	public Categorys getCategorys() {
		return categorys;
	}

	public Coachs getCoachs() {
		return coachs;
	}
}
