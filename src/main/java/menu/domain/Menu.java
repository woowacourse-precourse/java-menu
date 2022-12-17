package menu.domain;

public class Menu {

    private Category category;
    private String name;

    Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
