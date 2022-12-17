package menu;

public class Menu {

    private final String name;
    private final Category category;

    public Menu(Service service, ValidMenus valid) {
        this.name = valid.getName();
        this.category = service.findCategoryByName(ValidCategories.finaCategoryByName(valid.getName()).getKorean());
        category.addMenu(this);
    }

    public String getName() {
        return name;
    }
}
