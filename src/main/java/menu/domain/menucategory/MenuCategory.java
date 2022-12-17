package menu.domain.menucategory;

public class MenuCategory {

    private final SelectedCount selectedCount;
    private final String name;

    public MenuCategory(String name) {
        this.name = name;
        this.selectedCount = SelectedCount.generate();
    }

    public static MenuCategory from(String name) {
        return new MenuCategory(name);
    }

    public void select() {
        selectedCount.add();
    }

    public boolean canSelect() {
        return selectedCount.canSelect();
    }

    public String name() {
        return name;
    }
}
