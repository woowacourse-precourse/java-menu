package menu;

import camp.nextstep.edu.missionutils.Randoms;

public class CategoryRandomNumberGenerator implements RandomNumberGenerator{
    private static final int RANDOM_CATEGORY_LOWER_INCLUSIVE = 1;
    private static final int RANDOM_CATEGORY_UPPER_INCLUSIVE = 5;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_CATEGORY_LOWER_INCLUSIVE, RANDOM_CATEGORY_UPPER_INCLUSIVE);
    }
}
