package menu.model;

import java.util.List;

public class MenuResult {
    private String coachName;
    private List<Menu> menuList;

    public MenuResult(String coachName, List<Menu> menuList) {
        this.coachName = coachName;
        this.menuList = menuList;
    }

    public String getCoachName() {
        return coachName;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
}
