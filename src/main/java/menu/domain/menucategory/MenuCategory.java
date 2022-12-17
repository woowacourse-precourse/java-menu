package menu.domain.menucategory;

public class MenuCategory {
    private static final int MAX_SELECTED_COUNT = 2;
    private int selectedCount;
    private final String name;

    public MenuCategory(String name) {
        this.name = name;
        this.selectedCount = 0;
    }

    public void select() {
        selectedCount++;
    }

    public boolean canSelect() {
        return this.selectedCount < MAX_SELECTED_COUNT;
    }

    public String name() {
        return name;
    }
}
