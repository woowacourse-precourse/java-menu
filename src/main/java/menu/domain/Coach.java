package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<Menu> hateMenu = new ArrayList<>();

    public Coach(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void enrollHateFood(List<Menu> menus){
        for(Menu menu : menus){
            if(hateMenu.contains(menu)){
                continue;
            }
            hateMenu.add(menu);
        }
    }

    public boolean isSame(Coach otherCoach){
        return this.name == otherCoach.name;
    }

    public boolean canEat(Menu menu){
        for(Menu hateFood : hateMenu){
            if(hateFood.isSame(menu)){
                return false;
            }
        }
        return true;
    }
}
