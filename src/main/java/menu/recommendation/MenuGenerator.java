package menu.recommendation;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;
import menu.model.Menu;

public class MenuGenerator {
    Menu menus = new Menu();

    /**
     * 메뉴를 해당 카테고리에 맞는 단일로 추천한다.
     *
     * @param recommendMenus
     * @param todayCategory
     * @param dontEatMenus
     * @return
     */
    public String recommendMenu(List<String> recommendMenus, Category todayCategory, List<String> dontEatMenus) {
        String recommendMenu = validation(recommendMenus, dontEatMenus, todayCategory);
        return recommendMenu;
    }

    /**
     * 메뉴가 못먹거나 중복되지는 않는지 검증한다.
     *
     * @param recommended
     * @param dontEat
     * @param todayCategory
     * @return
     */
    public String validation(List<String> recommended, List<String> dontEat, Category todayCategory) {
        String menu = null;
        while (true) {
            menu = Randoms.shuffle(menus.getInstance(todayCategory.getValue())).get(0);
            if (!(recommended.contains(menu) || dontEat.contains(menu))) {
                break;
            }
        }
        return menu;
    }
}
