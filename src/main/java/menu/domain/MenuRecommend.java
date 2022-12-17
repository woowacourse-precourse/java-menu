package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.repository.FoodRepository;
import menu.repository.MenuRecommendRepository;

public class MenuRecommend {

    private final CategoryRecommend categoryRecommend;
    private final Coach coach;
    private Food food;

    public MenuRecommend(CategoryRecommend categoryRecommend, Coach coach) {
        this.categoryRecommend = categoryRecommend;
        this.coach = coach;
        this.food = getRandomMenu(categoryRecommend.getCategory());
    }

    public Food getRandomMenu(Category category) {
        List<String> menus = FoodRepository.getAllFoodsByCategory(category);
        String menu = Randoms.shuffle(menus).get(0);
        Food food = FoodRepository.getByName(menu);
        if (!validateMenu(food)) {
            getRandomMenu(category);
        }
        return food;
    }

    private boolean validateMenu(Food food) {
        return validateUniqueMenu(food) || validateNotContainsCannotEatMenus(food);
    }

    private boolean validateUniqueMenu(Food food) {
        return !MenuRecommendRepository.hasSameMenuOnCoach(this.coach, food);
    }

    private boolean validateNotContainsCannotEatMenus(Food food) {
        List<Food> cannotEatFoods = this.coach.getCannotEatFoods();
        return !cannotEatFoods.contains(food);
    }

    public Food getFood() {
        return food;
    }

    public boolean hasSameCoach(Coach coach) {
        return this.coach.equals(coach);
    }

    public boolean hasSameMenu(Food food) {
        return this.food.equals(food);
    }

    public boolean hasSameCategoryRecommend(CategoryRecommend categoryRecommend) {
        return this.categoryRecommend.equals(categoryRecommend);
    }

    public String getCoachName() {
        return coach.getName();
    }
}
