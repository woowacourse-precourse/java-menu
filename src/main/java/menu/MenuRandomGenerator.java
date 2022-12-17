package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MenuRandomGenerator {
    public static String selectRandomCategory() {
        String category = Category.findByNumber(Randoms.pickNumberInRange(1, 5)).getCategoryName();
        return category;
    }

    public static String selectRandomMenu(String categoryName) {
        List<String> menus = Category.findByName(categoryName).getMenus();
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }
}
