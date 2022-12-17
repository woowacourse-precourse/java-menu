package menu.domain;

public class Coach {

    private final String name;
    private final Menus unpleasantMenus;

    public Coach(String name, Menus unpleasantMenus) {
        this.name = name;
        this.unpleasantMenus = unpleasantMenus;
    }

    public void validateName(String name) {

    }
    @Override
    public String toString() {
        return name;
    }
}
