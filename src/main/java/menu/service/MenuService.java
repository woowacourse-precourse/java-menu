package menu.service;

import menu.domain.Category;
import menu.domain.MenuSelector;
import menu.domain.Coach;
import menu.domain.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    public static final int MONDAY = 0;
    public static final int FRIDAY = 5;

    public List<Category> recommend(List<Coach> coaches) {
        List<Category> categories = new ArrayList<>();

        setRecommendMenu(coaches, categories);
        return categories;
    }

    private void setRecommendMenu(List<Coach> coaches, List<Category> categories) {
        int day = MONDAY;
        while (day < FRIDAY) {
            Category category = getCategory();
            category.addCount();
            categories.add(category);
            addMenu(coaches, category);
            day++;
        }
    }

    private void addMenu(List<Coach> coaches, Category category) {
        coaches.forEach(coach -> {
            coach.addMenu(getMenuByCategory(coach, category));
        });
    }

    public Category getCategory() {
        Category category;
        while (true) {
            category = MenuSelector.getCategory();
            if (category.canChoose()) {
                break;
            }
        }
        return category;
    }

    public Menu getMenuByCategory(Coach coach, Category category) {
        Menu menu;
        while (true) {
            menu = MenuSelector.getMenu(category);
            if (coach.canEat(menu) && coach.hasNotSameMenu(menu)) {
                break;
            }
        }
        return menu;
    }
}
