package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constants.Category;

public class RandomMenuValueGenerator implements RandomMenuGenerator {
    private static final int FIRST_INDEX = 0;

    @Override
    public String generate(Category category) {
        return Randoms.shuffle(category.getMenus()).get(FIRST_INDEX);
    }
}
