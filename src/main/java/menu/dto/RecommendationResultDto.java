package menu.dto;

import java.util.List;

public class RecommendationResultDto {
    private final List<List<String>> categories;
    private final List<List<String>> recommendationResult;

    public RecommendationResultDto(List<List<String>> categories, List<List<String>> recommendationResult) {
        this.categories = categories;
        this.recommendationResult = recommendationResult;
    }

    public List<List<String>> getCategories() {
        return categories;
    }

    public List<List<String>> getRecommendationResult() {
        return recommendationResult;
    }
}
