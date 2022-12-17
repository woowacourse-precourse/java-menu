package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constants.Category;

public class RandomMenuValueGenerator implements RandomMenuGenerator {

    @Override
    public String generate(Category category) {
        return Randoms.shuffle(category.getMenus()).get(0);
    }
}
