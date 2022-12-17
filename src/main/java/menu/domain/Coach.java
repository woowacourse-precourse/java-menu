package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String coachName;
    private final List<Menu> cannotEatMenus = new ArrayList<>();

    public Coach(String coachName, List<String> cannotEatMenus) {
        this.coachName = coachName;
        for(String menu : cannotEatMenus) {
            this.cannotEatMenus.add(new Menu(menu));
        }
    }

    public boolean existsCannotEatMenus(Menu menu) {
        for(Menu cannotEatMenu : cannotEatMenus) {
            if(cannotEatMenu == menu) {
                return true;
            }
        }
        return false;
    }
}
