package menu.domain.draw;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.category.Category;

public class CategoryDraw {
    public static Category categoryDraw() {
        return Category.findByCategoryNumber(Randoms.pickNumberInRange(1, 5));
    }
}
