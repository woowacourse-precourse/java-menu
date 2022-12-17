package menu.domain;

import java.util.*;
public class Coach {

    public String name;
    public List<Category> eatCategorys;
    public Set<String> notEatMenus;
    public List<String> menuRecommendResult;

    public Coach(String name) {
        this.name = name;
        this.eatCategorys = new ArrayList<>();
        this.notEatMenus = new HashSet<>();
        this.menuRecommendResult = new ArrayList<>();
    }

    public void addRecommendedMenu(String recommendedMenu){
        this.menuRecommendResult.add(recommendedMenu);
    }

    public void addNotEatMenu(String notEatMenu){
        notEatMenus.add(notEatMenu);
    }
    
}
