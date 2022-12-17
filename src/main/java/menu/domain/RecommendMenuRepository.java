package menu.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecommendMenuRepository {
    private final List<Coach> coaches;
    private final Map<Coach, List<String>> dislikeMenus;
    private final Map<Coach, List<String>> recommendMenus;
    private final List<Category> categories = new ArrayList<>();

    public RecommendMenuRepository(CoachRepository coachRepository, DislikeMenuRepository dislikeMenus) {
        this.coaches = coachRepository.coaches();
        this.dislikeMenus = dislikeMenus.menus();
        this.recommendMenus = new LinkedHashMap();
        getRandomCategory();
        getRecommendMenu();
    }

    private void getRandomCategory() {
        while(categories.size()<5){
            Category randomCategory = Category.getRandomCategory();
            if(validateCategoryRange(randomCategory)) categories.add(randomCategory);
        }
    }

    private boolean validateCategoryRange(Category randomCategory) {
        int count = 0;
        for (Category category : categories){
            System.out.println("검사하는 항목"+category);
            if(category == randomCategory) count++;
        }
        System.out.println("카운트" + count);
        System.out.println(count<2);
        return count<2;
    }

    private void getRecommendMenu() {
        for(Coach coach: coaches){
            List<String> recommendMenus = new ArrayList<>();
            for(Category category : categories){
                recommendMenus.add(getRandomMenu(recommendMenus, category, coach));
            }
            this.recommendMenus.put(coach, recommendMenus);
        }
    }

    private String getRandomMenu(List<String> recommendMenus, Category category, Coach coach) {
        String randomMenu = category.getRandomMenu();
        if(recommendMenus.contains(randomMenu)) return getRandomMenu(recommendMenus, category, coach);
        if(dislikeMenus.containsKey(coach) && dislikeMenus.get(coach).contains(randomMenu)){
            return getRandomMenu(recommendMenus, category, coach);
        }
        return randomMenu;
    }

    public List<Category> categories() {
        return categories;
    }

    public Map<Coach, List<String>> recommendMenus() {
        return recommendMenus;
    }
}
