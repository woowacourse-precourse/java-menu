package menu.model.menutable;

import menu.model.coach.Coach;
import menu.model.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class CoachState {
    private Coach coach;
    private List<Menu> exceptedMenuList;

    CoachState(Coach coach) {
        this.coach = coach;
        this.exceptedMenuList = new ArrayList<>(coach.getHatingMenuList());
    }

    public void addExceptedMenu(Menu exceptedMenu) {
        exceptedMenuList.add(exceptedMenu);
    }

    public List<Menu> getExceptedMenu() {
        return new ArrayList<>(exceptedMenuList);
    }
}
