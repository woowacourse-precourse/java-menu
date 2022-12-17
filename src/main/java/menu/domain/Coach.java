package menu.domain;

import menu.resource.Day;

import java.util.*;

public class Coach {

    private String name;
    private Map<Day,String> foodPerDay = new LinkedHashMap<>();
    private List<String> foodCantEat = new ArrayList<>();

    public Coach(String name){
        this.name = name;
        initiateFoodPerDay();
    }

    public void addCantEatFood(Food food){
        foodCantEat.add(food.getName());
    }

    private void initiateFoodPerDay() {
        List<Day> days = List.of(Day.values());
        for(int i=0;i<days.size();i++){
            foodPerDay.put(days.get(i),"");
        }
    }

    public String getName() {
        return name;
    }

    public boolean ifNotIncludeInCantEat(String foodName){
        if(foodCantEat.contains(foodName)){
            return false;
        }
        return ifFoodDuplicate(foodName);
    }

    public void addNewFood(Day day,String foodName){
        foodPerDay.put(day,foodName);
    }

    public Map<Day, String> getFoodPerDay() {
        return foodPerDay;
    }

    public boolean ifFoodDuplicate(String foodName){
        for(Day day: foodPerDay.keySet()){
            if(foodPerDay.get(day).equals(foodName)){
                return false;
            }
        }
        return true;
    }

}
