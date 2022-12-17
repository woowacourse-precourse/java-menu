package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.Foods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static menu.option.Option.CATEGORIES;

public class CoachController {
    List<String> categoryList;
    HashMap<String,Integer> categoryCnt;
    Coach coach;
    HashMap<String,Coach> coaches;
    List<String> coachList;
    Foods foods;
    public CoachController(){
        this.foods = new Foods();
        this.categoryList = new ArrayList<>();
        this.categoryCnt = new HashMap<>();
        for(String category: CATEGORIES){
            this.categoryCnt.put(category,0);
        }
    }
    public void makeCoachList(String coaches){
        this.coaches = new HashMap<>();
        this.coachList = new ArrayList<>();
        for(String coach:coaches.split(",")){
            this.coaches.put(coach,new Coach(coach));
            this.coachList.add(coach);
        }
    }
    public void makeCantEat(String coach,String cantEat){
        this.coaches.get(coach).makeCantEatList(cantEat);
    }
    public void makeFoodList(){
        for(String category:categoryList){
            makeAllCoach(category);
        }
    }
    private void makeAllCoach(String category){
        for(String coach:coachList){
            recommendFood(category,coach);
        }
    }
    private void recommendFood(String category,String coach){
        String food =  Randoms.shuffle(Foods.getFoodsList().get(category)).get(0);
        if(!coaches.get(coach).getFoodList().contains(food)){
            coaches.get(coach).addFoodList(food);
            return;
        }
        if(!coaches.get(coach).getCantEatList().contains(food)){
            coaches.get(coach).addFoodList(food);
            return;
        }
        recommendFood(category,coach);
    }

    public String recommendCategory(){
        String randomCategory = CATEGORIES[Randoms.pickNumberInRange(1,5)-1];
        if(categoryList.size()==5) return randomCategory;
        if(categoryCnt.get(randomCategory)<=2){
            categoryCnt.put(randomCategory,categoryCnt.get(randomCategory)+1);
            categoryList.add(randomCategory);
            return randomCategory;
        }
        return recommendCategory();
    }
    public Boolean checkCnt(){
        for(int cnt:categoryCnt.values()){
            if(cnt>2) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    public HashMap<String, Coach> getCoaches(){return this.coaches;}
    public List<String> getCategoryList(){return this.categoryList;}
    public List<String> getCoachList(){return this.coachList;}
}
