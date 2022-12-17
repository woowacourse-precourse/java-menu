package menu.domain;

import java.util.List;

public class Recommendation {
    private final List<Coach> coaches;
    private final CategoryCount categoryCount;
    private final CategoryMaker categoryMaker;

    public Recommendation(List<Coach> coaches) {
        this.coaches = coaches;
        categoryCount = new CategoryCount();
        categoryMaker = new CategoryMaker();
    }

    public void run() {
        Category category = selectCategory();
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

}
