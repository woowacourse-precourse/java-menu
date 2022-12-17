package menu.domain.menu;

import java.util.Objects;

public class MenuName {
    private final String menuName;
    
    public MenuName(String menuName) {
        this.menuName = menuName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuName menuName1 = (MenuName) o;
        return Objects.equals(menuName, menuName1.menuName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(menuName);
    }
    
    @Override
    public String toString() {
        return "MenuName{" +
                "menuName='" + menuName + '\'' +
                '}';
    }
}
