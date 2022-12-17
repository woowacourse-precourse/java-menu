package menu.repository;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;

public class MenuRepository {

	// 카테고리 반환
	public Category getRandomCategory() throws Exception {
		int pickNumber = Randoms.pickNumberInRange(1, 5);
		Category category = Category.getCategory(pickNumber);
		return category;
	}

}
