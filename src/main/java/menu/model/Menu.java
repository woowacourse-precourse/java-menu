package menu.model;

public class Menu {
    private MenuCategory category;
    private String name;

    public Menu(final MenuCategory category, final String name) {
        this.category = category;
        this.name = name;
    }

    public String getCategoryName() {
        return category.getCategory();
    }

    public String getName() {
        return name;
    }
}
