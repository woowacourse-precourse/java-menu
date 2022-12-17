package menu.model.menu;

public class Menu {
    private final String name;
    private final Category category;
    
    public Menu(String name) {
        this.name = name;
        this.category = Category.getByMenuName(name);
    }

    public String getName() {
        return name;
    }
}
