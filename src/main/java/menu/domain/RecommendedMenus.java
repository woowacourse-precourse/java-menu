package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendedMenus {

    private List<String> recommendedMenus;

    public RecommendedMenus() {
        this.recommendedMenus = new ArrayList<>();
    }

    public void addRecommendedMenu(String menu) {
        recommendedMenus.add(menu);
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }
}
