package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.controller.RecommendResult;
import menu.domain.Coach;
import menu.domain.FoodCategory;
import menu.domain.Menu;
import menu.repository.MenuRepository;

public class RecommendService {

    public static final int MIN_CATEGORY_NUM = 1;
    public static final int MAX_CATEGORY_NUM = 5;
    public static final int RECOMMEND_DAYS = 5;

    private final Map<FoodCategory, Integer> categoryCounts = new HashMap<>();
    private final Map<Coach, List<Menu>> eatFoods = new HashMap<>();

    public RecommendResult recommend(List<Coach> coaches) {
        List<FoodCategory> foodCategories = new ArrayList<>();
        for (int i = 0; i < RECOMMEND_DAYS; i++) {
            recommend(coaches, foodCategories);
        }
        return new RecommendResult(foodCategories, eatFoods);
    }

    private void recommend(List<Coach> coaches, List<FoodCategory> foodCategories) {
        FoodCategory foodCategory = recommendCategory();
        foodCategories.add(foodCategory);
        for (Coach coach : coaches) {
            recommendMenu(foodCategory, coach);
        }
    }

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

    public void recommendMenu(FoodCategory foodCategory, Coach coach) {
        try {
            recommendToCoach(foodCategory, coach);
        } catch (IllegalStateException e) {
            recommendToCoach(foodCategory, coach);
        }
    }

    private void recommendToCoach(FoodCategory foodCategory, Coach coach) {
        String menuName = getRandomMenu(foodCategory);
        Menu menu = new Menu(menuName);
        validateCanNotEatMenu(coach, menu);

        List<Menu> eatMenus = eatFoods.getOrDefault(coach, new ArrayList<>());
        validateAlreadyEat(menu, eatMenus);
        eatMenus.add(menu);
        eatFoods.put(coach, eatMenus);
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

    private String getRandomMenu(FoodCategory foodCategory) {
        List<String> menus = MenuRepository.findByFoodCategory(foodCategory)
            .stream().map(Menu::getName)
            .collect(Collectors.toList());
        return Randoms.shuffle(menus).get(0);
    }
}
