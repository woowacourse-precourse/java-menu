package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendationMenuRepository {
    public static final List<RecommendationMenu> recommendationMenus = new ArrayList<>();

    public static void addRecommendationMenu(RecommendationMenu recommendationMenu) {
        recommendationMenus.add(recommendationMenu);
    }

    public static RecommendationMenu findRecommendationMenuByCoachName(String coachName) {
        for (RecommendationMenu recommendationMenu : recommendationMenus) {
            if (recommendationMenu.getCoachName().equals(coachName)) {
                return recommendationMenu;
            }
        }
        return null;
    }
}
