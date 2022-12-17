package menu.domain;

import menu.util.CategoryChoicer;
import menu.util.MenuChoicer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeekDiet {
    private final List<Week> weeks = Arrays.stream(Week.values()).collect(Collectors.toList());
    private List<FoodCategory> weekFoodCategories;
    private Map<Coach,List<String>> weekDietByCoachs;

    {
        weekDietByCoachs = new HashMap<>();
    }

    public void generateFoodCataegories(){
        List<FoodCategory> createdFoodCategories = CategoryChoicer.makeWeekCategories();

        if(is3DuplicateCategoriesInList(createdFoodCategories)){
            generateFoodCataegories();
            return;
        }

        weekFoodCategories = createdFoodCategories;
    }

    private boolean is3DuplicateCategoriesInList(List<FoodCategory> createdFoodCategories){
        for(FoodCategory foodCategory : createdFoodCategories){
            List<FoodCategory> copy = new ArrayList(createdFoodCategories);
            copy.retainAll(List.of(foodCategory));
            if(copy.size()>2) return true;
        }
        return false;
    }

    public void generateDietByCoachs(Coachs coachs){
        for(Coach coach : coachs.getCoachs()){
            weekDietByCoachs.put(coach, createMenusByCoach(coach));
        }
    }

    //TODO: 리펙토링 냄새
    private List<String> createMenusByCoach(Coach coach){
        List<String> createdMenus = MenuChoicer.makeWeekMenus(weekFoodCategories);

        for(String inedible : coach.getInedibles()) {
            if (createdMenus.contains(inedible)) {
                return createMenusByCoach(coach);
            }
        }

        int originSize = createdMenus.size();

        if(createdMenus.stream().distinct().count()!=originSize) return createMenusByCoach(coach);

        return createdMenus;

    }

    public List<Week> getWeeks() {
        return Collections.unmodifiableList(weeks);
    }

    public List<FoodCategory> getWeekFoodCategories() {
        return Collections.unmodifiableList(weekFoodCategories);
    }

    public Map<Coach, List<String>> getWeekDietByCoachs() {
        return Collections.unmodifiableMap(weekDietByCoachs);
    }
}
