package menu.domain;

import java.util.*;

public class WeeklyMenus {
    private StringJoiner days = new StringJoiner(" | ", "[ 구분 | ", " ]");
    private StringJoiner categories = new StringJoiner(" | ", "[ 카테고리 | ", " ]");
    private Map<Coach, StringJoiner> coachesMenu = new HashMap<>();

    public WeeklyMenus(List<Coach> coaches) {
        coaches.stream()
                .forEach(coach -> coachesMenu.put(coach,
                        new StringJoiner(" | ", "[ "+coach.getName()+" | ", " ]")));

    }

    public void addWeeklyMenu(Day day, WeeklyMenu weeklyMenu) {
        this.days.add(day.getDay());
        this.categories.add(weeklyMenu.getCategory().getName());
        weeklyMenu.getCoachesMenu().stream()
                .forEach(coachMenu -> {
                    Coach coach = coachMenu.getCoach();
                    String menu = coachMenu.getMenu();
                    this.coachesMenu.get(coach).add(menu);
                });
    }

    public String getDays() {
        return days.toString();
    }

    public String getCategories() {
        return categories.toString();
    }

    public List<String> getCoachesMenus() {
        List<String> menus = new ArrayList<>();
        coachesMenu.keySet().stream()
                .forEach(coach -> menus.add(coachesMenu.get(coach).toString()));
        return menus;
    }
}
