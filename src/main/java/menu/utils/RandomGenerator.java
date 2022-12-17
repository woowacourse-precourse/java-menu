package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;
import menu.enums.MenuOption;

import java.util.List;

public class RandomGenerator {

    public String randomCategoryChoice() {
        return MenuOption.getCategoryFromNumber(Randoms.pickNumberInRange(1, 5));
    }

    public String randomMenuChoice(List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);

        return menu;
    }
}
