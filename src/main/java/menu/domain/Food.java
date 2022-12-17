package menu.domain;

public class Food {

    private String name;
    private Category category;

    public Food(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public boolean hasSameName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category.getName();
    }
}
