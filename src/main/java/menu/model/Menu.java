package menu.model;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class Menu {
    private final MenuCategory menuCategory;
    private final String name;


    public Menu(MenuCategory menuCategory, String name) {
        this.menuCategory = menuCategory;
        this.name = name;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public String getName() {
        return name;
    }
}
