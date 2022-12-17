package menu.model;

public class Menu {
    private MenuCategory category;
    private String name;

    public Menu(final MenuCategory category, final String name) {
        this.category = category;
        this.name = name;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
