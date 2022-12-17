package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RecommendationTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("요일별 카테고리 추천")
    public void addCategory(int iter) {
        Recommendation recommendation = new Recommendation();

        for (int i = 0; i < iter; i++) {
            recommendation.addCategory();
        }

        assertThat(recommendation.categories.size()).isEqualTo(iter);
    }

    @Test
    @DisplayName("5일 이상 추가할 수 없다")
    public void addCategoryUntil5() {
        Recommendation recommendation = new Recommendation();

        for (int i = 0; i < 5; i++) {
            recommendation.addCategory();
        }

        assertThatIllegalStateException().isThrownBy(recommendation::addCategory)
                .withMessageStartingWith("이미 모든 요일의 추천이 완료되었습니다.");
    }
}