package menu.domain.vo;

import java.util.List;

public class CoachMenu {
    private final String coachName;
    public final List<String> menus;

    public CoachMenu(String coachName, List<String> menus) {
        this.coachName = coachName;
        this.menus = menus;
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getMenus() {
        return menus;
    }
}
