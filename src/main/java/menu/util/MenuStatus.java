package menu.util;

public enum MenuStatus {
    NOT_EAT("미정");

    private final String menu;

    MenuStatus(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }
}
