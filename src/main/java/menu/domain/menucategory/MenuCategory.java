package menu.domain.menucategory;

public class MenuCategory {
    private final int selectedCount;
    private final String name;

    public MenuCategory(String name) {
        this.name = name;
        this.selectedCount = 0;
    }
}
