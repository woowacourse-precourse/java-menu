package menu.domain;

public class Menu {

    private final String menuName;
    private final Category category;

    public Menu(String menuName, Category category) {
        this.menuName = menuName;
        this.category = category;
    }
}
