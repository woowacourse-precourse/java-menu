package menu;

public class Day {

    private final String name;
    private final Category category;

    public Day(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
