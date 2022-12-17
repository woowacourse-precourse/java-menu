package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Menus {

    private final Category category;
    private final List<Menu> menus;

    public Menus(Category category, List<Menu> menus) {
        this.category = category;
        this.menus = menus;
    }

    public boolean isExistedMenu(String menu) {
        for (Menu m : menus) {
            if (menu.equals(m.getName())) {
                return true;
            }
        }
        return false;
    }

    public Menu pickRandomMenu() {
        return Randoms.shuffle(menus).get(0);
    }
}
