package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import static menu.option.Option.CATEGORIES;


public class Coach {
    private String name;
    private List<String> cantEatList;
    private List<String> foodList;
    private HashMap<String,Integer> categoryCnt;
    public Coach(String name){
        this.name = name;
        this.foodList = new ArrayList<>();
        makeCategoryCnt();
    }
    public void makeCantEatList(String cantEat){
        cantEatList = new ArrayList<>();
        for(String food:cantEat.split(",")){
            this.cantEatList.add(food);
        }
    }
    private void makeCategoryCnt(){
        categoryCnt = new HashMap<String, Integer>();
        for(String category: CATEGORIES){
            categoryCnt.put(category,0);
        }
    }
    public List<String> getFoodList(){return foodList;}
    public List<String> getCantEatList(){return cantEatList;}
    public void addFoodList(String food){this.foodList.add(food);}
    public HashMap<String,Integer> getCategoryCnt(){return this.categoryCnt;}
    public void addCategoryCnt(String category){this.categoryCnt.put(category,categoryCnt.get(category) + 1);}
}
