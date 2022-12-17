package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.enums.Category;

public class RandomCategoryGenerator {
    public RandomCategoryGenerator() {
    }

    public Category create() {
        int i = Randoms.pickNumberInRange(1, 5);
        Category category = Category.valueOfNum(i);
        return category;
    }
}
