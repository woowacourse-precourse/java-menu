package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;


public final class CategoryRandomGenerator {

    private static final int FROM_INCLUSIVE = 1;
    private static final int TO_INCLUSIVE = 5;

    public String generate() {
        return Category.getByIndex(Randoms.pickNumberInRange(FROM_INCLUSIVE, TO_INCLUSIVE));
    }
}
