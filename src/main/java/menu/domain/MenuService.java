package menu.domain;

import java.util.List;

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
}
