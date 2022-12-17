package menu.domain;

public class Menu {
    private final Category category;
    private final String menuName;

    public Menu(String userInputMenu) {
        this.menuName = Category.validateAndGetMenuName(userInputMenu);
        this.category = Category.getCategory(userInputMenu);
    }
}
