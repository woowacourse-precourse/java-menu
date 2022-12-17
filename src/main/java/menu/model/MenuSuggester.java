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

    private void suggest(int day) {
        int category = Randoms.pickNumberInRange(1, 5);
        suggestedCategory[day] = category;

        for (Coach coach : coaches) {
            String menu = pickMenu(coach, category);
            coach.addFood(menu);
        }

    }

    private String pickMenu(Coach coach, int category) {
        List<String> menus = categories.get(category);
        boolean possible;
        String menu;
        do {
            menu = Randoms.shuffle(menus).get(0);
            possible = possibleMenu(coach, category, menu);
        } while (!possible);
        return menu;
    }

    private boolean possibleMenu(Coach coach, int category, String menu) {
        return uniqueMenu(coach, category, menu);
    }

    private boolean uniqueMenu(Coach coach, int category, String menu) {
        List<String> eatMenu = coach.getEatMenu();
        if (eatMenu.contains(menu)) {
            return false;
        }
        return true;
    }
}
