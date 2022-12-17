package menu.domain;

import java.util.Arrays;
import java.util.List;
import menu.domain.constant.Category;
import menu.domain.constant.Day;
import menu.domain.vo.CoachMenu;

public class MenuService {
    private final Coaches coaches;
    private final WeeklyCategory weeklyCategory;

    public MenuService() {
        this.coaches = new Coaches();
        this.weeklyCategory = new WeeklyCategory();
    }

    public void generateCoaches(List<String> coachNames) {
        coaches.addCoaches(coachNames);
    }

    public List<String> getCoachNames() {
        return coaches.getCoachNames();
    }

    public void registerInedibleFoodsToCoach(String coachName, List<String> inedibleFoods) {
        checkFoods(inedibleFoods);
        coaches.registerInedibleFoodsToCoach(coachName, inedibleFoods);
    }

    private void checkFoods(List<String> foods) {
        foods.forEach(Category::checkFoodExist);
    }

    public void recommendMenu() {
        Arrays.stream(Day.values())
                .forEach(day -> recommendMenuOfDay(day));
    }

    private void recommendMenuOfDay(Day day) {
        Category categoryOfDay = weeklyCategory.getCategoryOfDay(day);
        coaches.recommendMenuForEachCoach(day, categoryOfDay);
    }

    public List<CoachMenu> getCoachMenus() {
        return coaches.getCoachMenus();
    }
}
