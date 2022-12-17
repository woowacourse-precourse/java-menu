package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Recommendation {
    private final List<Coach> coaches;
    private final List<String> categories;
    private final CategoryCount categoryCount;
    private final CategoryMaker categoryMaker;
    private final MenuMaker menuMaker;

    public Recommendation(List<Coach> coaches) {
        this.coaches = coaches;
        categoryCount = new CategoryCount();
        categoryMaker = new CategoryMaker();
        menuMaker = new MenuMaker();
        categories = new ArrayList<>();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            Category category = selectCategory();
            categories.add(category.getName());
            selectMenu(category);
        }
    }

    private Category selectCategory() {
        Category category = null;

        boolean finish = false;
        while (!finish) {
            category = categoryMaker.generate();
            finish = categoryCount.canEat(category);
        }

        return category;
    }

    private void selectMenu(Category category) {
        List<String> menus = category.getMenu();

        for (Coach coach : coaches) {
            boolean finish = false;
            while (!finish) {
                String menu = menuMaker.generate(menus);
                finish = coach.canEat(menu);
            }
        }
    }

}
