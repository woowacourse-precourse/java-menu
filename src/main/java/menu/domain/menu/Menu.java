package menu.domain.menu;

import menu.domain.category.Category;

import java.util.Objects;

public class Menu {
    private final Category category;
    private final MenuName menuName;
    
    public Menu(String menuName, Category category) {
        this.menuName = new MenuName(menuName);
        this.category = category;
    }
    
    public boolean isSameCategory(Menu menu) {
        return this.category == menu.category;
    }
    
    public boolean isSameMenuName(String menuName) {
        return this.menuName.equals(new MenuName(menuName));
    }
    
    public String name() {
        return menuName.name();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return category == menu.category && Objects.equals(menuName, menu.menuName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(category, menuName);
    }
    
    @Override
    public String toString() {
        return "Menu{" +
                "category=" + category +
                ", menuName=" + menuName +
                '}';
    }
}
