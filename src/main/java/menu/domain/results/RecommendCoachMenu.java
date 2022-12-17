package menu.domain.results;

import java.util.ArrayList;
import java.util.List;
import menu.domain.coach.Coach;
import menu.domain.menu.Menu;

public class RecommendCoachMenu {
    private final Coach coach;
    private final List<Menu> menus = new ArrayList<>();

    private RecommendCoachMenu(Coach coach) {
        this.coach = coach;
    }

    public static RecommendCoachMenu of(Coach coach) {
        return new RecommendCoachMenu(coach);
    }

    public void addRecommendMenu(Menu menu) {
        if (isUnique(menu) && isEdible(menu)) {
            menus.add(menu);
            return;
        }

        throw new IllegalStateException();
    }

    private boolean isUnique(Menu menu) {
        return !menus.contains(menu);
    }

    private boolean isEdible(Menu menu) {
        return !coach.isAvoidMenu(menu);
    }
}
