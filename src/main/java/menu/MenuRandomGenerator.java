package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MenuRandomGenerator {
    public static String categoryRandomSelector() {
        String category = Category.findByNumber(Randoms.pickNumberInRange(1, 5)).getCategoryName();
        return category;
    }

    public static String menuRandomSelector(int menuNumber) {
        List<String> menus = Category.findByNumber(menuNumber).getMenus();
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }
}
