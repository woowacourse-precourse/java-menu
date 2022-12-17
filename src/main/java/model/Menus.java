package model;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    
    private final List<String> menus;
    
    public Menus() {
        this.menus = new ArrayList<>();
    }
    
    public void addMenu(String menu) {
        menus.add(menu);
    }
    
    public List<String> getMenus() {
        return menus;
    }
}
