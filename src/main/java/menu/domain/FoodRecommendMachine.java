package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FoodRecommendMachine {
    public static final int MAX_CATEGORY_NUM = 2;

    private FoodPeerCoaches coaches;
    private Map<DayRecommend, FoodCategory> foodRecommends;

    public FoodRecommendMachine(FoodPeerCoaches foodPeerCoaches) {
        this.coaches = foodPeerCoaches;
    }

    public void makeRecommend() {
        makeRecommendOf("월요일");
    }

    public void makeRecommendOf(String dayName) {
        DayRecommend dayRecommend = new DayRecommend(dayName);
        FoodCategory foodCategory = selectCategory();
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
}
