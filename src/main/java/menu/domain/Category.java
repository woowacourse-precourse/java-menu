package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Category {

    String category;
    List<Menu> menus;

    public Category(String category, List<Menu> menus) {
        this.category = category;
        this.menus = menus;
    }

    public Menu findMenu(String menu) {
        for (Menu eachMenu : menus) {
            if (eachMenu.getMenu().equals(menu)) {
                return eachMenu;
            }
        }
        return null;
    }

    public boolean haveMenu(String menu) {
        for (Menu eachMenu : menus) {
            if (eachMenu.getMenu().equals(menu)) {
                return true;
            }
        }
        return false;
    }

    public String getCategory() {
        return category;
    }

    public Menu getRandomMenu() {
        return Randoms.shuffle(menus).get(0);
    }
}
