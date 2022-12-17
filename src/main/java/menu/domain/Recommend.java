package menu.domain;

import menu.domain.enums.Category;
import menu.domain.enums.Weekday;

public class Recommend {

    private final Coach coach;
    private final Weekday weekday;
    private final Category category;
    private final Food food;

    public Recommend(Coach coach, Weekday weekday, Food food) {
        this.coach = coach;
        this.weekday = weekday;
        this.category = food.category();
        this.food = food;
    }

    public Coach coach() {
        return coach;
    }

    public Weekday weekday() {
        return weekday;
    }

    public Category category() {
        return category;
    }

    public Food food() {
        return food;
    }
}
