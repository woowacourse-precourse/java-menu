package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MenuSuggester {
    private List<Coach> coaches;
    private List<List<String>> categories;
    private int[] suggestedCategory;
    private final int SUGGEST_DAY = 5;
    private final int CATEGORY_MAX = 2;

    public MenuSuggester() {
        MenuGenerator menuGenerator = new MenuGenerator();
        categories = menuGenerator.generate();
        suggestedCategory = new int[SUGGEST_DAY];
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public int[] run() {
        for (int i = 0; i < suggestedCategory.length; i++) {
            suggest(i);
        }
        return suggestedCategory;
    }

    private void suggest(int idx) {
        int category = pickCategory(idx);
        for (Coach coach : coaches) {
            String menu = pickMenu(coach, category);
            coach.addFood(menu);
        }
    }

    private int pickCategory(int idx) {
        int category;
        do {
            category = Randoms.pickNumberInRange(1, 5);
        } while (!possibleCategory(category));
        suggestedCategory[idx] = category;
        return category;
    }

    private boolean possibleCategory(int category) {
        int count = 0;
        for (int i = 0; i < suggestedCategory.length; i++) {
            if (suggestedCategory[i] == category) {
                count++;
            }
        }
        if (count >= CATEGORY_MAX) {
            return false;
        }
        return true;
    }

    private String pickMenu(Coach coach, int category) {
        List<String> menus = categories.get(category);
        String menu;
        do {
            menu = Randoms.shuffle(menus).get(0);
        } while (!possibleMenu(coach, menu));
        return menu;
    }

    private boolean possibleMenu(Coach coach, String menu) {
        return coach.uniqueMenu(menu) && coach.eatableMenu(menu);
    }

}
