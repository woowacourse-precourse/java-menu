package menu.controller;

import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.Foods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public HashMap<String, Coach> getCoaches(){return this.coaches;}
}
