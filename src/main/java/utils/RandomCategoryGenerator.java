package utils;

import camp.nextstep.edu.missionutils.Randoms;
import menu.Category;

public class RandomCategoryGenerator {
    private static final int START = 1;
    private static final int END = 5;

    public static String getRandomCategory() {
        int randomNumber = Randoms.pickNumberInRange(START, END);

        return Category.getCategories(randomNumber);
    }
}
