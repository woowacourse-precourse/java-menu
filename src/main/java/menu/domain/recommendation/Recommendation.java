package menu.domain.recommendation;

import menu.domain.menu.Menu;
import menu.domain.week.Week;

public class Recommendation {
    private final Week week;
    private final Menu menu;
    
    public Recommendation(Week week, Menu menu) {
        this.week = week;
        this.menu = menu;
    }
    
    public boolean isSameMenu(Menu menu) {
        return this.menu.equals(menu);
    }
    
    public boolean isSameCategory(Menu menu) {
        return this.menu.isSameCategory(menu);
    }
}
