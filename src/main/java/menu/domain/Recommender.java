package menu.domain;

import java.util.List;
import java.util.Map;

public class Recommender {

    private static final int MAX_SAME_CATEGORY = 2;
    private static final int PICK_DATE_SIZE = 5;
    private final List<Category> categories;
    private final Map<Category, List<String>> menus;
    private final Picker picker;

    public Recommender(List<Category> categories, Map<Category, List<String>> menus, Picker picker) {
        this.categories = categories;
        this.menus = menus;
        this.picker = picker;
    }

    public void recommendTimes(List<Coach> coaches) {
        for (int i = 0; i < PICK_DATE_SIZE; i++) {
            recommendOneDay(coaches);
        }
    }

    private void recommendOneDay(List<Coach> coaches) {
        Category picked = pickCategory();
        List<String> oneCategoryMenus = menus.get(picked);
        for (Coach coach : coaches) {
            recommendOneDayOneCoach(coach, oneCategoryMenus);
        }
    }

    private Category pickCategory() {
        while (true) {
            Category newCategory = new CategoryPicker(picker).pickCategory();
            if (canPickCategory(categories, newCategory)) {
                categories.add(newCategory);
                return newCategory;
            }
        }
    }

    private boolean canPickCategory(List<Category> picked, Category newCategory) {
        return picked.stream()
                .filter(it -> it == newCategory)
                .count() < MAX_SAME_CATEGORY;
    }

    private void recommendOneDayOneCoach(Coach coach, List<String> oneCategoryMenus) {
        while (true) {
            String menu = getOneMenu(oneCategoryMenus);
            if (coach.canEat(menu)) {
                coach.eat(menu);
                break;
            }
        }
    }

    private String getOneMenu(List<String> oneCategoryMenus) {
        return picker.shuffle(oneCategoryMenus).get(0);
    }
}
