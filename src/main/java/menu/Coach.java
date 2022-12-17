package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {
    private final List<String> InedibleFoods;
    private final String name;
    private final List<String> thisWeekAteFoods = new ArrayList<>();

    public Coach(List<String> InedibleFoods, String name){
        this.InedibleFoods = InedibleFoods;
        this.name = name;
    }

    public void recommendAndEatFood(FoodInformation category){
        while(true){
            String cand = FoodInformation.getRandomFood(category);
            if(thisWeekAteFoods.contains(cand) || InedibleFoods.contains(cand))
                continue;

            thisWeekAteFoods.add(cand);
            return;
        }
    }

    public String getPrintForm(){
        String prefix = "[ " + name + " | ";
        String suffix = " ]";

        return thisWeekAteFoods.stream()
                .collect(Collectors.joining(" | ", prefix, suffix));
    }
}
