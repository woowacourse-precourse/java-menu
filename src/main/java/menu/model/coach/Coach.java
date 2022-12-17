package menu.model.coach;

import menu.model.Category;

import java.util.List;

public class Coach {

    private String name;
    private List<String> cannotEatFoods;
    private List<Category> alreadyEatenCategories;
    private List<String> alreadyEatenFoods;

    public Coach(String name) {
        this.name = name;
    }
    public boolean isEqualCoach(String coachName) {
        return this.name.equals(coachName);
    }

    public void updateCannotEatFoods(List<String> cannotEatFoods) {
        this.cannotEatFoods = cannotEatFoods;
    }
}
