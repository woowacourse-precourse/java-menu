package menu.domain.coach;

import menu.domain.menu.Menu;
import menu.domain.menu.UneatableMenus;
import menu.domain.recommendation.Recommendations;

import java.util.List;

public class Coach {
    private final CoachName coachName;
    private final Recommendations recommendations;
    private final UneatableMenus uneatableMenus;
    
    public Coach(String coachName) {
        this.coachName = new CoachName(coachName);
        this.recommendations = new Recommendations();
        this.uneatableMenus = new UneatableMenus();
    }
    
    public void addUneatableMenu(List<Menu> uneatableMenus) {
        this.uneatableMenus.addAll(uneatableMenus);
    }
    
    public boolean isUneatableMenu(Menu menu) {
        return this.uneatableMenus.contains(menu);
    }
    
    public boolean isExistSameCategoryOverTwo(Menu menu) {
        return recommendations.isExistSameCategoryOverTwo(menu);
    }
    
    public boolean isExistSameMenu(Menu menu) {
        return recommendations.isExistSameMenu(menu);
    }
}
