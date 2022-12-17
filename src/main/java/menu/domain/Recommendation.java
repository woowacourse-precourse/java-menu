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
        Category category = categoryMaker.generate();
        categoryCount.canEat(category);
    }

}
