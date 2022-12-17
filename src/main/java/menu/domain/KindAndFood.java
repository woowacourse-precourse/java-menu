package menu.domain;

public class KindAndFood {
    private String category;
    private Food food;

    public void addCategory(String category) {
        this.category = category;
    }

    public void addFood(Food food) {
        this.food = food;
    }

    public String getCategory() {
        return category;
    }

    public Food getFood() {
        return food;
    }


}
