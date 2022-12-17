package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomGenerator {

    public String randomMenuRecommand(List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);

        return menu;
    }
}
