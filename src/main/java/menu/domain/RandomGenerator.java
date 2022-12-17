package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomGenerator {
    private static final int RANDOM_CATEGORY_LOWER_INCLUSIVE = 1;
    private static final int RANDOM_CATEGORY_UPPER_INCLUSIVE = 5;

    public static String forCategory(List<String> categories) {
        return categories.get(Randoms.pickNumberInRange(RANDOM_CATEGORY_LOWER_INCLUSIVE
                , RANDOM_CATEGORY_UPPER_INCLUSIVE));
    }

    public static String forMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }

}
