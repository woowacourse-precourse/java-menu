package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    public String coachName;
    public List<Menu> impossibleMenus;
    public List<Menu> menuList;

    public Coach(String coachName, List<Menu> impossibleMenus) {
        this.coachName = coachName;
        this.impossibleMenus = impossibleMenus;
        menuList = new ArrayList<>();
    }

    public String getCoachName() {
        return coachName;
    }

    public List<Menu> getImpossibleMenus() {
        return impossibleMenus;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
}
