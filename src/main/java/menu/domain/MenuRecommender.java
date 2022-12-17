package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuRecommender {

    private final Map<Category, Menus> menus;

    public MenuRecommender(Map<Category, Menus> menus) {
        this.menus = menus;
    }

    public boolean isExistedMenu(String menu) {
        for (Menus menus : this.menus.values()) {
            if (menus.isExistedMenu(menu)) {
                return true;
            }
        }
        return false;
    }

    public List<Category> recommendCategories() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < 5) {
            int category = Randoms.pickNumberInRange(1, 5);
            categories.add(Category.get(category));
        }
        return categories;
    }
}
