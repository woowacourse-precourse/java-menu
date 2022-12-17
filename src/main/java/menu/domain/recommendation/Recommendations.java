package menu.domain.recommendation;

import menu.domain.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class Recommendations {
    private final List<Recommendation> recommendations;
    
    public Recommendations() {
        this.recommendations = new ArrayList<>();
    }
    
    public boolean isExistSameMenu(Menu menu) {
        return recommendations.stream()
                .anyMatch(oldRecommendation -> oldRecommendation.isSameMenu(menu));
    }
    
    public boolean isExistSameCategoryOverTwo(Menu menu) {
        return calculateCountOfSameCategory(menu) >= 2;
    }
    
    private int calculateCountOfSameCategory(Menu menu) {
        return (int) recommendations.stream()
                .filter(oldRecommendation -> oldRecommendation.isSameCategory(menu))
                .count();
    }
}
