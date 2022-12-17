package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> dislikeFood;
    private List<String> recommendedFood;

    Coach(String name, List<String> dislikeFood){
        this.name = name;
        this.dislikeFood = dislikeFood;
        this.recommendedFood = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public List<String> getRecommendedFood(){
        return recommendedFood;
    }

    public boolean isValidMenu(Menu menu){
        if (!dislikeFood.isEmpty() && dislikeFood.stream().anyMatch(foodName -> foodName.equals(menu.getMenuName()))){
            return false;
        }
        if (!recommendedFood.isEmpty() && recommendedFood.stream().anyMatch(foodName -> foodName.equals(menu.getMenuName()))){
            return false;
        }
        recommendedFood.add(menu.getMenuName());
        return true;
    }
}
