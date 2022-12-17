package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodRecommendMachine {
    public static final int MAX_CATEGORY_NUM = 2;

    private FoodPeerCoaches coaches;
    private Map<DayRecommend, FoodCategory> foodRecommends = new HashMap<>();

    public FoodRecommendMachine(FoodPeerCoaches foodPeerCoaches) {
        this.coaches = foodPeerCoaches;
    }

    public void makeRecommend() {
        makeRecommendOf("월요일");
        makeRecommendOf("화요일");
        makeRecommendOf("수요일");
        makeRecommendOf("목요일");
        makeRecommendOf("금요일");
    }

    private void makeRecommendOf(String dayName) {
        DayRecommend dayRecommend = new DayRecommend(dayName);
        FoodCategory foodCategory = selectCategory();
        makeTodayRecommend(dayRecommend, foodCategory);
        this.foodRecommends.put(dayRecommend, foodCategory);
    }

    private FoodCategory selectCategory() {
        FoodCategory randomCategory = FoodCategory.of(Randoms.pickNumberInRange(1, 5));
        while (!checkCategoryValid(randomCategory)) {
            randomCategory = FoodCategory.of(Randoms.pickNumberInRange(1, 5));
        }
        return randomCategory;
    }

    private boolean checkCategoryValid(FoodCategory foodCategory) {
        if (Collections.frequency(foodRecommends.values(), foodCategory) > MAX_CATEGORY_NUM) {
            return false;
        }
        return true;
    }

    private void makeTodayRecommend(DayRecommend dayRecommend, FoodCategory foodCategory) {
        List<Coach> coachesList = coaches.getCoaches();
        for (Coach coach : coachesList) {
            dayRecommend.enrollCouchMenu(coach, makeTodayMenuOf(coach, foodCategory));
        }
    }

    private Menu makeTodayMenuOf(Coach coach, FoodCategory foodCategory) {
        Menu randomMenu = getRandomMenuOf(foodCategory);
        while (!coach.canEat(randomMenu)) {
            randomMenu = getRandomMenuOf(foodCategory);
        }
        while (checkMenuDuplication(coach, randomMenu)) {
            randomMenu = getRandomMenuOf(foodCategory);
        }
        return randomMenu;
    }

    private Menu getRandomMenuOf(FoodCategory category) {
        return Randoms.shuffle(category.getMenus()).get(0);
    }

    private boolean checkMenuDuplication(Coach coach, Menu menu) {
        long count = foodRecommends.keySet().stream()
                .filter(dayRecommend -> dayRecommend.isCoachMenu(coach, menu))
                .count();
        if (count == 0) {
            return true;
        }
        return false;
    }
}
