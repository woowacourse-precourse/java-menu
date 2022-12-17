package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuSuggester {
    private List<Coach> coaches;
    private List<List<String>> categories;
    private int[] suggestedCategory;
    private final String[] days = {"월요일", "화요일", "수요일", "목요일", "금요일"};

    public MenuSuggester() {
        MenuGenerator menuGenerator = new MenuGenerator();
        categories = menuGenerator.generate();
        suggestedCategory = new int[5];
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public void run() {
        for (int i = 0; i < days.length; i++) {
            suggest(i);
        }
    }

    private void suggest(int day) {
        int category = Randoms.pickNumberInRange(1, 5);
        suggestedCategory[day] = category;

        for (Coach coach : coaches) {
            String menu = pickMenu(category);
            coach.addFood(menu);
        }
    }

    private String pickMenu(int category) {
        List<String> menus = categories.get(category);
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }
}
