package menu;

public class Day {

    private final String name;
    private final Category category;

    public Day(String name, ValidCategories category) {
        this.name = name;
        this.category = new Category(category);
    }

    public String getCategoryName() {
        return category.getName();
    }
}
