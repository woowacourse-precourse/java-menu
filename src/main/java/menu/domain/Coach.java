package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<Menu> noEatableMenus = new ArrayList<>();
    private final List<Menu> recommendMenus = new ArrayList<>();

    public Coach(String name){
        this.name = name;
    }

    public void addNoEatableMenu(Menu menu){
        noEatableMenus.add(menu);
    }

    public void addRecommendMenu(Menu menu){
        recommendMenus.add(menu);
    }
}
