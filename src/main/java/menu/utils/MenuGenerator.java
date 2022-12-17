package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Menu;

import java.util.List;

public class MenuGenerator {

    public static Menu generate(List<Menu> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
