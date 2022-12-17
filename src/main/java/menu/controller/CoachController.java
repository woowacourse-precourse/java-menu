package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.Foods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    private void recommendFood(String coach){

    }

    private String recommendCategory(String coach){
        String randomCategory = makeRandomCategory();
        if(coaches.get(coach).getCategoryCnt().get(randomCategory)<2){
            coaches.get(coach).addCategoryCnt(randomCategory);
            return randomCategory;
        }
        return recommendCategory(coach);
    }
    private String makeRandomCategory(){
        return CATEGORIES[Randoms.pickNumberInRange(0,4)];
    }
    public HashMap<String, Coach> getCoaches(){return this.coaches;}
}
