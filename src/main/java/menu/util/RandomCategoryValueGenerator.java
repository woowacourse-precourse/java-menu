package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constants.Category;

public class RandomCategoryValueGenerator implements RandomCategoryGenerator {
    private static final int MINIMUM_CATEGORY_NUMBER = 1;
    private static final int MAXIMUM_CATEGORY_NUMBER = 5;

    @Override
    public Category generate() {
        return Category.getCategoryByNumber(Randoms.pickNumberInRange(MINIMUM_CATEGORY_NUMBER,
                MAXIMUM_CATEGORY_NUMBER));
    }
}
