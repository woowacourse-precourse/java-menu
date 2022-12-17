package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCategoryGenerator implements CategoryGenerator{

    private static final int MIN_CATEGORY_NUMBER = 1;
    private static final int MAX_CATEGORY_NUMBER = 5;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_CATEGORY_NUMBER, MAX_CATEGORY_NUMBER);
    }
}
