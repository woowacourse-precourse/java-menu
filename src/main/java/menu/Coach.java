package menu;

import java.util.HashSet;
import java.util.Set;

public class Coach {
    private final String name;
    private Set<String> hateFood;
    private Set<String> recommendedCategory;
    private Set<String> recommendedFood;

    public Coach(String name) { // input view 에서 처리해야지, 조금 더 깔끔하게 처리할 수 있을 듯하다, 안 그러면 Model 측을 view 에서 건드려야함
        this.name = name;
        hateFood = new HashSet<>();
        recommendedCategory = new HashSet<>();
        recommendedFood = new HashSet<>();
    }

    public boolean isHateFood(String food) {
        return hateFood.contains(food); // 있으면 hate food 임
    }

    public boolean isRecommendedFood(String food) {
        return recommendedFood.contains(food);
    }

    public boolean isRecommendedCategory(String category) {
        return recommendedCategory.contains(category);
    }
}
