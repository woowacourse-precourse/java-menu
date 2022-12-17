package menu.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecommendMenuRepository {
    private final List<Coach> coaches;
    private final Map<Coach, List<Menu>> dislikeMenus;
    private final Map<Coach, List<Menu>> RecommendMenus = new LinkedHashMap();
    List<Category> categories = new ArrayList<>();

    public RecommendMenuRepository(CoachRepository coachRepository, DislikeMenuRepository dislikeMenus) {
        this.coaches = coachRepository.coaches();
        this.dislikeMenus = dislikeMenus.menus();
        getRandomCategory();
        getRecommendMenu();
    }

    private void getRandomCategory() {
        while(categories.size()<5){
            System.out.println("반복문");
            Category randomCategory = Category.getRandomCategory();
            if(validateCategoryRange(randomCategory)) categories.add(randomCategory);
        }
    }

    private boolean validateCategoryRange(Category randomCategory) {
        int count = 0;
        for (Category category : categories){
            if(category == randomCategory) count++;
        }
        return count<2;
    }

    private void getRecommendMenu() {
        for(Coach coach: coaches){
            for(Category category : categories){

            }
        }
    }

}
