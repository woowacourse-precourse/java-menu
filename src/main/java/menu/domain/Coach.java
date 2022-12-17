package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {

    private final String name;
    private List<String> cantEatMenu;
    private List<String> eatMenu;

    public Coach(String name) {
        this.name = name;
        cantEatMenu = new ArrayList<>();
        eatMenu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setCantEatMenu(List<String> cantEatMenu) {
        this.cantEatMenu = cantEatMenu;
    }

    public List<String> getEatMenu() {
        return Collections.unmodifiableList(eatMenu);
    }

    public void addEatMenu(Category category) {
        String menu = Randoms.shuffle(category.getMenu()).get(0);
        if (isExistMenu(cantEatMenu, menu) || isExistMenu(eatMenu, menu)) {
            addEatMenu(category);
            return;
        }
        eatMenu.add(menu);
    }

    private boolean isExistMenu(List<String> menuList, String menu) {
        return menuList.contains(menu);
    }
}
