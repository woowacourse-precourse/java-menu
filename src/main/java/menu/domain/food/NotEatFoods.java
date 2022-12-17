package menu.domain.food;

import java.util.List;
import menu.domain.Coach;

public class NotEatFoods {

    private final Coach coach;
    private final Foods foods;

    public NotEatFoods(Coach coach) {
        this.coach = coach;
        this.foods = new Foods();
    }

    public Coach getCoach() {
        return this.coach;
    }

    public void addNotEatFood(Food notEatFood) {
        foods.addFood(notEatFood);
    }

    public void addNotEatFoods(List<Food> notEatFoods) {
        notEatFoods.stream()
                .forEach(notEatFood -> addNotEatFood(notEatFood));
    }

    public boolean canEat(Food food) {
        return foods.canEat(food);
    }

}
