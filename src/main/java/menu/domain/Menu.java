package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Menu {

    private Category category;
    private List<String> menuList;

    public Menu(Category category, List<String> menuList) {
        this.category = category;
        this.menuList = menuList;
    }

    public String makeRandomMenu() {
        return Randoms.shuffle(menuList).get(0);
    }
}
