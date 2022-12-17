package menu.domain.coach;

import menu.domain.menu.Menu;
import menu.domain.menu.UneatableMenus;
import menu.domain.recommendation.Recommendation;
import menu.domain.recommendation.Recommendations;
import menu.domain.week.Week;

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
    
    public String name() {
        return coachName.name();
    }
    
    public void addMenu(Week week, Menu menu) {
        recommendations.addRecommendation(new Recommendation(week, menu));
    }
    
    public List<String> menuNames() {
        return recommendations.menuNames();
    }
    
    @Override
    public String toString() {
        return "Coach{" +
                "coachName=" + coachName +
                ", recommendations=" + recommendations +
                ", uneatableMenus=" + uneatableMenus +
                '}';
    }
}
