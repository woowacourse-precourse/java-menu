package menu;

import java.util.List;

public class WeekMenusDto {
    String coachName;
    List<String> menus;

    public WeekMenusDto(String coachName, List<String> menus) {
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
