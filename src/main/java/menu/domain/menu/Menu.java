package menu.domain.menu;

import java.util.Objects;

public class Menu {
    private final String menuName;
    
    public Menu(String menuName) {
        this.menuName = menuName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(menuName, menu.menuName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(menuName);
    }
    
    @Override
    public String toString() {
        return "Menu{" +
                "menuName='" + menuName + '\'' +
                '}';
    }
}
