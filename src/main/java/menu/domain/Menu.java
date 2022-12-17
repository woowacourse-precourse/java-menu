package menu.domain;

public class Menu {
    private final String menuName;

    Menu(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Menu)) {
            return false;
        }
        Menu menu = (Menu) obj;
        return menu.menuName.equals(menuName);
    }
}
