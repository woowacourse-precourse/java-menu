package menu.controller;

import menu.Category;
import menu.Coach;
import menu.FoodInformation;
import menu.view.Input;
import menu.view.Output;

import java.util.ArrayList;
import java.util.List;

public class RecommendationSystem {
    List<Coach> coachList = new ArrayList<>();
    private void calculateResult(){
        for(int day = 0; day < 5; ++day){
            FoodInformation todayCategory = Category.getProperCategory();
            coachList.forEach(coach -> coach.recommendAndEatFood(todayCategory));
        }
    }
    public void start(){
        List<String> coaches = Input.readCoachesName();
        for (String coach : coaches)
            coachList.add(new Coach(Input.readInedibleFoods(coach), coach));

        calculateResult();

        Output.printResult(coachList);
    }
}
