package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MenuRecommender {
    private List<Category> categoryHistory = new ArrayList<>();
    private List<Coach> coaches;
    private static final List<Category> CATEGORIES = Arrays.asList(Category.values());

    public MenuRecommender(List<Coach> coaches) {
        this.coaches = coaches;
    }

    private Category pickupCategory() {
        return CATEGORIES.get(Randoms.pickNumberInRange(1, 5));
    }

    private boolean validCategory(Category category) {
        return Collections.frequency(categoryHistory, category) == 3;
    }

    private String recommendMenu(Category category, Coach coach) {
        boolean inavailableMenu = true;
        String menu = null;

        while (inavailableMenu) {
            menu = Randoms.shuffle(category.getMenus()).get(0);
            inavailableMenu = coach.checkMenu(menu);
        }

        return menu;
    }
}
