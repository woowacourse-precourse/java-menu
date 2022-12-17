package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.enums.Category;

import java.util.List;

public class RandomMenuGenerator {
    public RandomMenuGenerator() {
    }

    public String create(Category category) {
        List<String> menus = category.getMenus();
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }
}
