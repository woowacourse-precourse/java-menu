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



}
