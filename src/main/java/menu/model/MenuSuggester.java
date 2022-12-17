package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuSuggester {
    private List<Coach> coaches;
    private List<List<String>> categories;
    private HashMap<Integer, Integer> suggestedCategory;

    public MenuSuggester() {
        MenuGenerator menuGenerator = new MenuGenerator();
        categories = menuGenerator.generate();
        suggestedCategory = new HashMap<>();
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public void suggest() {
        int category = Randoms.pickNumberInRange(1, 5);
        suggestedCategory.put(category, suggestedCategory.getOrDefault(category, 0) + 1);

        for (Coach coach : coaches) {
            String menu = pickMenu(category);
            System.out.println(menu);
        }

    }

    private String pickMenu(int category) {
        List<String> menus = categories.get(category);
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }
}
