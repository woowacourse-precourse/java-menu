package coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> alreadyEatFood;
    private List<String> hateFood;

    public Coach(String coachName) {
        this.name = coachName;
        this.alreadyEatFood = new ArrayList<>();
        this.hateFood = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public List<String> getAteFood(){
        return alreadyEatFood;
    }

    public List<String> getHateFood(){
        return hateFood;
    }

    public void updateHateFood(List<String> hateFoodList){
        this.hateFood.addAll(hateFoodList);
//        System.out.println(hateFood);
    }

    public void updateAteFood(String food){
        alreadyEatFood.add(food);
    }

}
