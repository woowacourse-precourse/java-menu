package menu;

import java.util.List;

public class Coach {
    private String name;
    private List<String> dislikeFood;
    private List<String> recommendedFood;

    Coach(String name, List<String> dislikeFood){
        this.name = name;
        this.dislikeFood = dislikeFood;
    }

    public String getName(){
        return name;
    }

    public boolean isValidMenu(Menu menu){
        if (recommendedFood.stream().anyMatch(foodName -> foodName.equals(menu.getMenuName())){
            return false;
        }
        recommendedFood.add(menu.getMenuName());
        return true;
    }
}
