package menu.domain;

import java.util.List;

public class Category {
    private List<String> recommendedCategory;

    public void addRecommendedCategory(String category) { recommendedCategory.add(category);}
    public boolean hasCategory(String category) {
        return true;
    }
}
