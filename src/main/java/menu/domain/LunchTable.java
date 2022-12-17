package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LunchTable {
    private static final int CATEGORY_SELECT_LIMIT = 2;
    private static final int MAX_CATEGORY_COUNT = 5;
    List<Categories> categories;
    List<Coach> coaches;
    HashMap<Coach, List<String>> foodsMatchingResult;

    public LunchTable(){
        categories = new ArrayList<>();
    }

    public void setCoaches(List<Coach> coaches){
        this.coaches = coaches;
        initFoodMatching();
    }

    private void initFoodMatching(){
        foodsMatchingResult = new HashMap<>();
        for(Coach coach: coaches){
            foodsMatchingResult.put(coach, new ArrayList<>());
        }
    }

    public boolean isCompleteCategories(){
        return categories.size() == MAX_CATEGORY_COUNT;
    }

    public void addCategory(Categories category){
        if(!isOverCategorySelectLimit(category)){
            categories.add(category);
        }
    }

    private boolean isOverCategorySelectLimit(Categories category){
        return (CATEGORY_SELECT_LIMIT <= categories.stream()
                .filter(selectCategory -> selectCategory.equals(category)).count());
    }

    private void matchingFood(){
        for(int i = 0; i<5; i++){
            matchCoachRandomFood(categories.get(i));
        }
    }

    private void matchCoachRandomFood(Categories category){
        for(Coach coach : coaches){
            addFoodToCoach(category, coach);
        }
    }

    private void addFoodToCoach(Categories category, Coach coach){

        String tmpSelectedFood = category.getRandomMenu();

        while(true){
            if(!foodsMatchingResult.get(coach).contains(tmpSelectedFood) && !coach.isBanFood(tmpSelectedFood)){
                foodsMatchingResult.get(coach).add(tmpSelectedFood);
                break;
            }
            tmpSelectedFood = category.getRandomMenu();
        }

    }

    public HashMap<Coach, List<String>> getFoodsMatchingResult(){
        matchingFood();
        return this.foodsMatchingResult;
    }
}
