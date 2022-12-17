package menu.domain;

public class Menu {
    private Category category;
    private String name;

    public Menu(Category category, String name){
        this.category = category;
        this.name =name;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
