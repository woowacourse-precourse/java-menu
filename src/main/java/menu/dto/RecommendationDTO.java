package menu.dto;

import java.util.List;

public class RecommendationDTO {
    private List<String> categories;
    private List<String> coaches;
    private List<List<String>> recommendedMenus;

    public RecommendationDTO(List<String> categories, List<String> coaches, List<List<String>> recommendedMenus) {
        this.categories = categories;
        this.coaches = coaches;
        this.recommendedMenus = recommendedMenus;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<String> getCoaches() {
        return coaches;
    }

    public List<List<String>> getRecommendedMenus() {
        return recommendedMenus;
    }
}
