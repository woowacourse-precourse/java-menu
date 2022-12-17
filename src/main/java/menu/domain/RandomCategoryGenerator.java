package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCategoryGenerator implements CategoryGenerator {

    private final static int MIN_CATEGORY_ORDER = 1;
    private final static int MAX_CATEGORY_ORDER = 5;

    @Override
    public Category generate() {
        return Category.of(Randoms.pickNumberInRange(MIN_CATEGORY_ORDER, MAX_CATEGORY_ORDER));
    }
}
