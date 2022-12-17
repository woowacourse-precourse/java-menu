package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCategoryGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 5;

    public static Category generate() {
        int randomCategoryNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return Category.getCategory(randomCategoryNumber);
    }
}
