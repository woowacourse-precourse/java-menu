package menu;

public class Menu {

    private final String name;
    private final Category category;

    public Menu(ValidMenus valid) {
        this.name = valid.getName();
        this.category = new Category(ValidCategories.finaCategoryByName(valid.getName()));
    }

    public String getName() {
        return name;
    }
}
