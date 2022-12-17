package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class WeeklyMenu {
    private final Category category;
    private final List<CoachMenu> coachesMenu;

    private WeeklyMenu(Category category, List<CoachMenu> coachesMenu) {
        this.category = category;
        this.coachesMenu = coachesMenu;
    }

    public static WeeklyMenu from(Category category, List<CoachMenu> coachesMenu) {
        return new WeeklyMenu(category, coachesMenu);
    }

    public boolean isSameCategory(Category category) {
        return this.category.equals(category);
    }

    public boolean isDuplicatedCoachMenu(CoachMenu coachMenu) {
        return this.coachesMenu.contains(coachMenu);
    }
}
