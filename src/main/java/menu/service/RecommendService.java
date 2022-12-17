package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.FoodCategory;
import menu.domain.Menu;
import menu.repository.MenuRepository;

public class RecommendService {
    public static final int MIN_CATEGORY_NUM = 1;
    public static final int MAX_CATEGORY_NUM = 5;

    private static final Map<FoodCategory, Integer> categoryCounts = new HashMap<>();
    private static final Map<Coach, List<Menu>> eatFoods = new HashMap<>();


    public FoodCategory recommendCategory() {
        try {
            return recommendCategory(getRandoms());
        } catch (IllegalStateException e) {
            return recommendCategory();
        }
    }

    private int getRandoms() {
        return Randoms.pickNumberInRange(MIN_CATEGORY_NUM, MAX_CATEGORY_NUM);
    }

    public FoodCategory recommendCategory(int randomNum) {
        FoodCategory category = getCategory(randomNum);
        Integer counts = categoryCounts.getOrDefault(category, 0);
        if (counts >= 2) {
            throw new IllegalStateException("이미 2번 추천되었습니다");
        }
        categoryCounts.put(category, counts + 1);
        return category;
    }

    private FoodCategory getCategory(int randomNum) {
        return FoodCategory.findByNumber(randomNum);
    }

    public Menu recommendMenu(FoodCategory foodCategory, Coach coach) {
        try {
            return recommendToCoach(foodCategory, coach);
        }catch (IllegalStateException e) {
            return recommendToCoach(foodCategory, coach);
        }
    }

    private Menu recommendToCoach(FoodCategory foodCategory, Coach coach) {
        Menu menu = getRandomMenu(foodCategory);
        validateCanNotEatMenu(coach, menu);

        List<Menu> eatMenus = eatFoods.getOrDefault(coach, new ArrayList<>());
        validateAlreadyEat(menu, eatMenus);
        eatMenus.add(menu);
        eatFoods.put(coach, eatMenus);
        return menu;
    }

    private void validateAlreadyEat(Menu menu, List<Menu> eatMenus) {
        if (eatMenus.contains(menu)) {
            throw new IllegalStateException("이미 코치가 먹은 음식입니다");
        }
    }

    private void validateCanNotEatMenu(Coach coach, Menu menu) {
        if (coach.canNotEat(menu)) {
            throw new IllegalStateException("코치가 안먹는 음식입니다");
        }
    }

    private Menu getRandomMenu(FoodCategory foodCategory) {
        List<Menu> menus = MenuRepository.findByFoodCategory(foodCategory);
        return Randoms.shuffle(menus).get(0);
    }
}
