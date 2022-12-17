package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.menu.Category;

import java.util.List;

public class MenuRecommend {

    public String selectCategory() {
        String category = Category.get(Randoms.pickNumberInRange(1, 5));
        return category;
    }

    public String selectMenu(List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }
}
