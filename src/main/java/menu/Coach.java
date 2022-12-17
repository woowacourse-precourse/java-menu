package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {
    List<String> canNotEatFoods;
    String name;
    List<String> thisWeekAteFoods = new ArrayList<>();

    public Coach(List<String> canNotEatFoods, String name){
        this.canNotEatFoods = canNotEatFoods;
        this.name = name;
    }

    public String recommendFood(FoodInformation category){
        while(true){
            String cand = FoodInformation.getRandomFood(category);
            if(thisWeekAteFoods.contains(cand) || canNotEatFoods.contains(cand))
                continue;
            
            thisWeekAteFoods.add(cand);
            return cand;
        }
    }

    public String getPrintForm(){
        String prefix = "[ " + name + " | ";
        String suffix = " ]";

        return thisWeekAteFoods.stream()
                .collect(Collectors.joining(" | ", prefix, suffix));
    }
}
