package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.menu.Category;

public class MenuRecommend {

    public String selectCategory() {
        String category = Category.get(Randoms.pickNumberInRange(1, 5));
        return category;
    }
}
