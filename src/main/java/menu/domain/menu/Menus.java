package menu.domain.menu;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private final List<Menu> menus;
    
    public Menus() {
        menus = new ArrayList<>();
    }
    
    public boolean isExistSameMenu(Menu menu) {
        return menus.stream()
                .anyMatch(oldMenu -> oldMenu.equals(menu));
    }
}
