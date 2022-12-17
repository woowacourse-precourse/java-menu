package menu.model;

import java.util.ArrayList;
import java.util.List;

public class MenusOfWeek {
    List<Menu> menus;

    public MenusOfWeek(){
        menus = new ArrayList<>();
    }

    public void add(Menu menu){
        menus.add(menu);
    }

    public List<Menu> getMenus(){
        return menus;
    }
}
