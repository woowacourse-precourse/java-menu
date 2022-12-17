package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MenuSuggester {
    private List<Coach> coaches;
    private List<List<String>> categories;
    private int[] suggestedCategory;

    public MenuSuggester() {
        MenuGenerator menuGenerator = new MenuGenerator();
        categories = menuGenerator.generate();
        suggestedCategory = new int[5];
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
        boolean possible;
        int category;
        do {
            category = Randoms.pickNumberInRange(1, 5);
            possible = possibleCategory(category);
        } while (!possible);
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
        if (count >= 2) {
            return false;
        }
        return true;
    }

    private String pickMenu(Coach coach, int category) {
        List<String> menus = categories.get(category);
        boolean possible;
        String menu;
        do {
            menu = Randoms.shuffle(menus).get(0);
            possible = possibleMenu(coach, menu);
        } while (!possible);
        return menu;
    }

    private boolean possibleMenu(Coach coach, String menu) {
        return uniqueMenu(coach, menu) && eatableMenu(coach, menu);
    }

    private boolean uniqueMenu(Coach coach, String menu) {
        return coach.newFood(menu);
    }

    private boolean eatableMenu(Coach coach, String menu) {
        return coach.eatable(menu);
    }
}
