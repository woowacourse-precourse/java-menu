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

    public void registerInedibleMenusToCoach(String coachName, List<String> inedibleMenus) {
        checkMenus(inedibleMenus);
        coaches.registerInedibleMenusToCoach(coachName, inedibleMenus);
    }

    private void checkMenus(List<String> menus) {
        if (haveOnlyEmptyValue(menus)) {
            return;
        }
        menus.forEach(Category::checkMenuExist);
    }

    private boolean haveOnlyEmptyValue(List<String> menus) {
        if (menus.get(0).equals("")) {
            return true;
        }
        return false;
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

    public List<String> getCategoriesOfWeek() {
        return weeklyCategory.getCategoriesOfWeek();
    }
}
