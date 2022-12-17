package menu.domain;

import java.util.List;

public class MenuRecommender {

    public void selectCategories(NumberGenerator numberGenerator, Group group) {
        for (int i = 0; i < DayOfWeek.values().length; i++) {
            int code = numberGenerator.generate(Category.MIN_CATEGORY_CODE, Category.MAX_CATEGORY_CODE);
            recommendMenu(group, Category.from(code));
        }
    }

    private void recommendMenu(Group group, Category category) {
        List<String> menuNames = Menu.findByCategory(category);

    }
}
