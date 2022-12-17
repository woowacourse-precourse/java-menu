package menu.domain;

import java.util.Collections;
import java.util.List;
import menu.domain.enums.Menu;

public class CoachRecommendMenu {
    private final Coach coach;
    private final RecommendMenu recommendMenu;

    public CoachRecommendMenu(final Coach coach, final RecommendMenu recommendMenu) {
        this.coach = coach;
        this.recommendMenu = recommendMenu;
    }

    public String getCoachName() {
        return coach.getName();
    }

    public List<Menu> getMenuList() {
        return Collections.unmodifiableList(recommendMenu.getMenus());
    }
}
