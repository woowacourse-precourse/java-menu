package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Couch {
    private final String name;
    private List<Menu> hateMenu = new ArrayList<>();

    public Couch(String name){
        this.name = name;
    }

    public void enrollHateFood(List<Menu> menus){
        for(Menu menu : menus){
            if(hateMenu.contains(menu)){
                continue;
            }
            hateMenu.add(menu);
        }
    }

    public boolean canEat(Menu menu){
        for(Menu hateFood : hateMenu){
            if(hateFood.getMenuName().equals(menu.getMenuName())){
                return false;
            }
        }
        return true;
    }
}
