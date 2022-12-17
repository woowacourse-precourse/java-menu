package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class WeeklyMenu {
    private Category category;
    private List<CoachMenu> coachesMenu = new ArrayList<>();

    public boolean isSameCategory(Category category) {
        return this.category.equals(category);
    }
}
