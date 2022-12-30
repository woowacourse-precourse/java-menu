package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import menu.enums.MenuOption;

import java.util.List;

public class RandomMenuGenerator {

    public String randomCategoryChoice() {
        return MenuOption.getCategoryFromNumber(Randoms.pickNumberInRange(1, 5));
    }

    public String randomMenuChoice() {
        List<String> menus = MenuOption.getAllMenus();

        return Randoms.shuffle(menus).get(0);
    }
}
