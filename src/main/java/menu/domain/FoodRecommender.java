package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodRecommender {
    private static final int COACH_MIN_SIZE = 2;
    private static final int COACH_MAX_SIZE = 5;

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
            Menu randomMenu = getRandomMenu(category, coach);
            coach.putDayByMenu(day, randomMenu);
        }
    }

    private Menu getRandomMenu(FoodCategory category, Coach coach) {
        String menuName = Randoms.shuffle(category.getFoods()).get(0);
        Menu menu = MenuRepository.findByName(menuName);
        if (coach.isBlacklist(menu) || coach.isDuplicate(menu)) {
            return getRandomMenu(category, coach);
        }
        return menu;
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < COACH_MIN_SIZE || coaches.size() > COACH_MAX_SIZE) {
            throw new IllegalArgumentException("코치는 2~5명 사이만 입력 가능합니다.");
        }
    }

    private FoodCategory generateCategory(Day day) {
        FoodCategory category = FoodCategory.of(
                Randoms.pickNumberInRange(FoodCategory.getFirstNumber(), FoodCategory.getLastNumber()));
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
