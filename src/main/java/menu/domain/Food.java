package menu.domain;

public class Food {
    FoodCategory foodCategory;
    String name;

    public Food(FoodCategory foodCategory, String name) {
        this.foodCategory = foodCategory;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }
}
