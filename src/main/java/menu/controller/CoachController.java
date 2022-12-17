package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.Foods;

import java.util.HashMap;

import static menu.option.Option.CATEGORIES;

public class CoachController {
    Coach coach;
    HashMap<String,Coach> coaches;
    Foods foods;
    Food food;
    public CoachController(){
        this.foods = new Foods();
    }
    public void makeCoachList(String coaches){
        this.coaches = new HashMap<>();
        for(String coach:coaches.split(",")){
            this.coaches.put(coach,new Coach(coach));
        }
    }
    public void makeCantEat(String coach,String cantEat){
        this.coaches.get(coach).makeCantEatList(cantEat);
    }
    public void recommendFood(String coach){
        String category = recommendCategory(coach);
        String food =  Randoms.shuffle(Foods.getFoodsList().get(category)).get(0);
        if(!coaches.get(coach).getFoodList().contains(food)){
            coaches.get(coach).addFoodList(food);
            return;
        }
        if(coaches.get(coach).getFoodList().contains(food)){
            coaches.get(coach).addFoodList(food);
            return;
        }
        recommendFood(coach);
    }

    private String recommendCategory(String coach){
        String randomCategory = CATEGORIES[Randoms.pickNumberInRange(1,5)-1];
        if(coaches.get(coach).getCategoryCnt().get(randomCategory)<=2){
            coaches.get(coach).addCategoryCnt(randomCategory);
            return randomCategory;
        }
        return recommendCategory(coach);
    }
    public HashMap<String, Coach> getCoaches(){return this.coaches;}
}
