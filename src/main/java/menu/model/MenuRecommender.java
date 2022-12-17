package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MenuRecommender {
    public static String recommendMenu(Category category) {
        List<String> menus = category.getMenus();
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }
}
