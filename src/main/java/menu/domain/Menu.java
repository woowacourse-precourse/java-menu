package menu.domain;

public class Menu {
    private final String menuName;

    public Menu(String menuName) {
        this.menuName = menuName;
    }

    public boolean isSame(Menu otherMenu) {
        return this.menuName == otherMenu.menuName;
    }
}
