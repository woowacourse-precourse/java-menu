package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecommendationTest {
    @Test
    @DisplayName("요일별 카테고리 추천")
    public void createRecommendation() {
        Recommendation recommendation = new Recommendation();
        for(Category category: recommendation.categories) {
            System.out.println(category.name());
        }
        assertThat(recommendation.categories.size()).isEqualTo(5);
    }
}