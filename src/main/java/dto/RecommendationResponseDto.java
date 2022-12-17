package dto;

import java.util.List;

public class RecommendationResponseDto {
    private final List<List<String>> recommendation;

    public RecommendationResponseDto(List<List<String>> recommendation) {
        this.recommendation = recommendation;
    }

    public List<List<String>> getRecommendation() {
        return recommendation;
    }
}
