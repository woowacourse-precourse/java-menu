package menu.domain;

public class Food {

    private String name;
    private Category category;

    public Food(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }
}
