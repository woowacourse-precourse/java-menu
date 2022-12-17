package menu.repository;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;

public class MenuRepository {

	// 카테고리 반환
	public Category getRandomCategory() throws Exception {
		int pickNumber = Randoms.pickNumberInRange(1, 5);
		Category category = Category.getCategory(pickNumber);
		return category;
	}

	// 입력된 카테고리로 랜덤 메뉴 반환
	public String getRandomMenuInCategory(Category category) {
		List<String> menus = category.getMenus();
		Randoms.shuffle(menus);
		return menus.get(0);
	}

}
