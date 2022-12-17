package menu.recommendation;

import menu.model.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class RecommendationGeneratorTest {
    RecommendationGenerator recommendationGenerator = new RecommendationGenerator();

    @DisplayName("일주일치 카테고리 추천")
    @Test
    void 일주일치_카테고리_추천() {
        List<Category> categories = recommendationGenerator.recommendCategory();
        final int expextedSize = 5;
        final int expextedMaxCategoryNum = 3;

        assertThat(categories.size()).isEqualTo(expextedSize);
        for (Category category : Category.values()) {
            assertThat(Collections.frequency(categories, category))
                    .isLessThan(expextedMaxCategoryNum);
        }

    }

    @DisplayName("카테고리 전환 테스트")
    @Test
    void 카테고리_숫자_문자열_전환_테스트() {
        int i = 1;
        for (Category category : Category.values()) {
            assertThat(recommendationGenerator.categoryConvertor(i))
                    .isEqualTo(category);
            i++;
        }
    }
}