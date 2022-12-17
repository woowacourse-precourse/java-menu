package menu.domain.menu;

public class Food {
    private String categori;
    private String foodName;

    Food(String categori, String foodName) {
        this.categori =categori;
        this.foodName = foodName;
    }

    public static Food of(String categori, String foodName) {
        return new Food(categori, foodName);
    }
}
