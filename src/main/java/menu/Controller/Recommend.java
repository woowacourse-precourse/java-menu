package menu.Controller;

import menu.Model.Category;
import menu.Model.Coachs;
import menu.Model.Coach;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Recommend {
    private final int WEEK_NUMBER = 5;
    private final int START_CATEGORY_RANK = 1;
    private final int END_CATEGORY_RANK = 5;
    private Map<Category, Integer> categoryCounts = new HashMap<>();

    public Recommend() {
        for (Category cg : Category.values()) {
            categoryCounts.put(cg, 0);
        }
    }

    public void makeRecommendations(Coachs coachs) {
        for (int i = 0; i < WEEK_NUMBER; i++) {
            Category cg = pickCategory();
            chooseMenu(coachs, cg.getMenus());
        }
    }

    private void chooseMenu(Coachs coachs, List<String> menus) {
        for (Coach coach : coachs.getCoachs()) {
            setMenuUntilValid(coach, menus);
        }
    }

    private void setMenuUntilValid(Coach coach, List<String> menus) {
        while (true) {
            String menu = Randoms.shuffle(menus).get(0);
            if (coach.setRecommendOrFalse(menu))
                return;
        }
    }

    private Category pickCategory() {
        while (true) {
            int rank = Randoms.pickNumberInRange(START_CATEGORY_RANK, END_CATEGORY_RANK);
            Category cg = Category.getCategoryFromNumber(rank);
            int count = categoryCounts.get(cg);
            if (!(count > 1)) {
                categoryCounts.put(cg, count + 1);
                return cg;
            }
        }
    }
}
