package menu.service;


import java.util.List;

import menu.domain.RecommendCategory;

public class MenuService {

    private final RecommendCategory recommendCategory;

    public MenuService(RecommendCategory recommendCategory) {
        this.recommendCategory = recommendCategory;
    }

    public void selectCategoryForEachDay() {
        recommendCategory.recommend();
    }

    public String getRecommendCategoryWord() {
        return recommendCategory.toString();
    }

    public List<String> getRecommendCategory() {
        return recommendCategory.getCategories();
    }
}
