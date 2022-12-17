package menu.coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> foodNotEat;
    private List<String> foodEaten;

    public Coach(String name) {
        this.name = name;
        this.foodNotEat = new ArrayList<>();
        this.foodEaten = new ArrayList<>();
    }

    public void addFoodNotEat(String food) {
        foodNotEat.add(food);
    }

     public void addfoodEaten(String food) {
         foodEaten.add(food);
     }

     public boolean isEat(String food) {
         return validate(food, foodNotEat) && validate(food, foodEaten);
     }

     private boolean validate(String food, List<String> notEatFood) {
         return !notEatFood.contains(food);
     }

}
