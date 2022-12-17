package menu;

import java.util.HashSet;
import java.util.Set;

public class Coach {
    private final String DUPLICATE_HATE_FOOD = "이미 등록된 싫어하는 음식입니다.";
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

    public void setHateFood(String food) {
        if (hateFood.contains(food)) {
            hateFood.clear(); // 잘 못 입력 받는 경우 이전에 받은 것들도 다 날려야하기 때문에, clear 를 해준다.
            throw new IllegalArgumentException(SystemConstant.ERROR + DUPLICATE_HATE_FOOD);
        }
    }

    public boolean isHateFood(String food) {
        return hateFood.contains(food); // 있으면 hate food 임
    }

    public boolean isPossibleRecommendCategory(String category) {
        Set<String> tempRecommendCategory = new HashSet<>(recommendedCategory);
        tempRecommendCategory.add(category);

        return tempRecommendCategory.size() <= 2; // 이러면 추천 가능한 것
    }

    public boolean isPossibleRecommendFood(String food) {
        return !recommendedFood.contains(food); // true 이면 추천 가능한 것
    }

    public void recommendCategory(String category) {
        recommendedCategory.add(category);
    }

    public void recommendFood(String food) {
        recommendedFood.add(food);
    }
}
