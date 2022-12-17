package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodRecommender {

    private final Coaches coaches;
    private final Map<Day, FoodCategory> foodCategories;

    public FoodRecommender(List<Coach> coaches) {
        this.coaches = new Coaches(coaches);
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
        for (Coach coach : coaches.get()) {
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
