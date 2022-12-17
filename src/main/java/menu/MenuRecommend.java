package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.Food;
import menu.resource.Category;
import menu.resource.Day;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuRecommend {

    private CategoryChoose categoryChoose = new CategoryChoose();
    private Map<Day, Category> categorys = new LinkedHashMap<>();

    public Map<Day, Category> getCategorys() {
        return categorys;
    }


    public MenuRecommend(){
        initiateCategoryPerDay();
    }
    public MenuRecommend(List<Coach> coaches, List<Food> foods){
        initiateCategoryPerDay();
        chooseCategory(coaches,foods);
    }

    public void chooseCategory(List<Coach> coaches,List<Food> foods) {
        for(Day day : categorys.keySet()){
            Category category = makeMenuPerDay(day,foods,coaches);
            categorys.put(day,category);
        }
    }
    private Category makeMenuPerDay(Day day,List<Food> foods,List<Coach> coaches) {
        Category category = categoryChoose.getRandomCategory();
        while(category == null){
            category = categoryChoose.getRandomCategory();
        }
        List<Food> categoryFood = getSpecificCategoryFood(foods, category);
        for(int i=0;i<coaches.size();i++){
            addNewDayFood(day, coaches.get(i), categoryFood);
        }
        return category;
    }
    private List<Food> getSpecificCategoryFood(List<Food> foods, Category category) {
        Category finalCategory = category;
        List<Food> categoryFood = foods
                .stream()
                .filter(f->f.getCategory().equals(finalCategory))
                .collect(Collectors.toList());
        return categoryFood;
    }

    private void addNewDayFood(Day day, Coach coach, List<Food> categoryFood) {
        List<String> foodNames = categoryFood.stream()
                .map(f->f.getName())
                .collect(Collectors.toList());
        while(true){
            String foodName = Randoms.shuffle(foodNames).get(0);
            if (ifCoachCantEat(coach, foodName)) continue;
            coach.addNewFood(day,foodName);
            return;
        }
    }

    private boolean ifCoachCantEat(Coach coach, String foodName) {
        if(!coach.ifNotIncludeInCantEat(foodName)){
            return true;
        }
        if(!coach.ifFoodDuplicate(foodName)){
            return true;
        }
        return false;
    }

    private void initiateCategoryPerDay() {
        List<Day> days = List.of(Day.values());
        for(int i=0;i<days.size();i++){
            categorys.put(days.get(i),null);
        }
    }
}
