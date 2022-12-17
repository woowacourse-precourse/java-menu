package model;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    
    private final List<String> menus;
    
    Menus() {
        menus = new ArrayList<>();
    }
    
    void addMenu(String menu) {
        menus.add(menu);
    }
    
    List<String> getMenus() {
        return menus;
    }
    
    boolean isMenuReduplication(String menu) {
        return menus.contains(menu);
    }
    
    @Override
    public String toString() {
        return menus.toString();
    }
}
