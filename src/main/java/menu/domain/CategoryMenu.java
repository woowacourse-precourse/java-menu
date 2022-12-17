package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CategoryMenu {
    private final Category category;
    private final List<String> menus;

    public CategoryMenu(Category category, List<String> menus) {
        this.category = category;
        this.menus = menus;
    }

    public boolean findSameCategory(Category randomCategory) {
        return category == randomCategory;
    }

    public List<String> shuffleMenu() {
        List<String> copyMenus = new ArrayList<>(menus);
        return Randoms.shuffle(copyMenus);
    }
}
