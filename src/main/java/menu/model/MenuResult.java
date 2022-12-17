package menu.model;

import java.util.List;

public class MenuResult {
    private String coachName;
    private List<String> menuList;

    public MenuResult(String coachName, List<String> menuList) {
        this.coachName = coachName;
        this.menuList = menuList;
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getMenuList() {
        return menuList;
    }
}
