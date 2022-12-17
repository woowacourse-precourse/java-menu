package menu.domain;

import java.util.HashMap;
import java.util.List;

import static menu.domain.Foods.getFoodsList;
import static menu.option.Option.CATEGORIES;
import static menu.option.Option.WEEK;

public class Coach {
    private String name;
    private List<Food> cantEatList;
    private HashMap<String,Food> foodList;
    private HashMap<String,Integer> categoryCnt;
    public Coach(String name){
        this.name = name;
        makeCategoryCnt();
        makeFoodList();
    }
    public void makeCantEatList(String cantEat){
        for(String food:cantEat.split(",")){
            this.cantEatList.add(getFoodsList().get(food));
        }
    }
    private void makeFoodList(){
        this.foodList = new HashMap<String,Food>();
        for(String day: WEEK){
            foodList.put(day,null);
        }
    }
    private void makeCategoryCnt(){
        categoryCnt = new HashMap<String, Integer>();
        for(String category: CATEGORIES){
            categoryCnt.put(category,0);
        }
    }
    public HashMap<String,Integer> getCategoryCnt(){return this.categoryCnt;}
    public void addCategoryCnt(String category){this.categoryCnt.put(category,categoryCnt.get(category) + 1);}
}
