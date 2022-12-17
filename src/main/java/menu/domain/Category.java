package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Category {

    private final String name;
    private final List<String> menu;

    public Category(String name, List<String> menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendMenu(Coach coach) {
        List<String> recommendedMenu = new ArrayList<>();
        List<String> cantEatMenu = coach.getCantEatMenu();
        while (recommendedMenu.size() != 5) {
            String menu = Randoms.shuffle(this.menu).get(0);
            if (isExistMenu(recommendedMenu, menu) || isExistMenu(cantEatMenu, menu)) {
                continue;
            }
            recommendedMenu.add(menu);
        }
        return recommendedMenu;
    }

    private boolean isExistMenu(List<String> menuList, String menu) {
        return menuList.contains(menu);
    }
}
