package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Coach {
    private String name;
    private HashSet<String> hates;
    private List<String> meals = new ArrayList<>();

    public Coach(String name, HashSet<String> hates) {
        this.name = name;
        this.hates = hates;
    }

    public String getName() {
        return name;
    }

    public HashSet<String> getHates() {
        return hates;
    }

    public List<String> getMeals() {
        return meals;
    }

    public void makeMeals(WeeklyRecommendCategory weeklyCategory) {
        List<Integer> categoryIdx = weeklyCategory.getCategoryIdxs();
        for (int idx : categoryIdx) {
            List<String> eachMenus = Category.getWantCategoryMenu(idx);
            String menu = Randoms.shuffle(eachMenus).get(0);
            while (meals.contains(menu) || hates.contains(menu)) {
                menu = Randoms.shuffle(eachMenus).get(0);
            }
            meals.add(menu);
        }
    }
}
