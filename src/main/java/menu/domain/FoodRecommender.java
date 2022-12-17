package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodRecommender {
    private final List<Coach> coaches;
    private Map<Day, FoodCategory> foodCategories;

    public FoodRecommender(List<Coach> coaches) {
        validateSize(coaches);
        this.coaches = coaches;
        foodCategories = new HashMap<>();
    }

    public MenuResult recommendByDay() {
        for (Day day : Day.values()) {
            FoodCategory category = generateCategory(day);
            setMenuByDayAndCategory(day, category);
        }
        return new MenuResult(coaches, foodCategories);
    }

    private void setMenuByDayAndCategory(Day day, FoodCategory category) {
        for (Coach coach : coaches) {
            String randomMenu = getRandomMenu(category, coach);
            coach.putDayByMenu(day, randomMenu);
        }
    }

    private String getRandomMenu(FoodCategory category, Coach coach) {
        String menu = Randoms.shuffle(category.getFoods()).get(0);
        if (coach.isBlacklist(menu) || coach.isDuplicate(menu)) {
            return getRandomMenu(category, coach);
        }
        return menu;
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("코치는 2~5명 사이만 입력 가능합니다.");
        }
    }

    private FoodCategory generateCategory(Day day) {
        FoodCategory category = FoodCategory.of(Randoms.pickNumberInRange(1, 5));
        if (getCategorySelectCount(category) == 2) {
            return generateCategory(day);
        }
        foodCategories.put(day, category);
        return category;
    }

    private long getCategorySelectCount(FoodCategory category) {
        return foodCategories.values()
                .stream()
                .filter(foodCategory -> foodCategory == category)
                .count();
    }

}
