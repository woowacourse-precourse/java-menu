package menu.domain;

import java.util.List;

public class Coach {
    private final String name;
    private List<String> banFoods;

    public Coach(String name){
        this.name = name;
    }
    public void setBanFoods(List<String> banFoods){
        this.banFoods = banFoods;
    }

    public boolean isBanFood(String food){
        return banFoods.contains(food);
    }
}
