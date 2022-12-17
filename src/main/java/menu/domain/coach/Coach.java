package menu.domain.coach;

import menu.domain.menu.Menu;
import menu.domain.menu.Menus;
import menu.domain.menu.UneatableMenus;

public class Coach {
    private final CoachName coachName;
    private final Menus menus;
    private final UneatableMenus uneatableMenus;
    
    public Coach(String coachName) {
        this.coachName = new CoachName(coachName);
        this.menus = new Menus();
        this.uneatableMenus = new UneatableMenus();
    }
    
    public boolean isExistSameMenu(Menu menu) {
        return menus.isExistSameMenu(menu);
    }
}
