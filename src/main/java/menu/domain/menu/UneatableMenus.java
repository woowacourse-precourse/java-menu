package menu.domain.menu;

import java.util.ArrayList;
import java.util.List;

public class UneatableMenus {
    private final List<Menu> menus;
    
    public UneatableMenus() {
        menus = new ArrayList<>();
    }
    
    public void addAll(List<Menu> uneatableMenus) {
        menus.addAll(uneatableMenus);
    }
    
    public boolean contains(Menu menu) {
        return menus.contains(menu);
    }
}
