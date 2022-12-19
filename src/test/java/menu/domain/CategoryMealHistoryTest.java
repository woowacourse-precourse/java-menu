package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("추천된 카테고리 관련 테스트")
class RecommendCategoryInfoTest {
    RecommendCategoryInfo categoryMealHistory = new RecommendCategoryInfo();
    @ParameterizedTest
    @MethodSource("generateCategoryData")
    void 같은_카테고리는_최대_두_번만_가능하다(CategoryMenu category, boolean result) {
        categoryMealHistory.mealCategory(CategoryMenu.KOREA_FOOD);
        categoryMealHistory.mealCategory(CategoryMenu.KOREA_FOOD);
        Assertions.assertThat(categoryMealHistory.isPossibleCategory(category)).isEqualTo(result);
    }

    static Stream<Arguments> generateCategoryData() {
        return Stream.of(
                Arguments.of(CategoryMenu.ASIA_FOOD, true),
                Arguments.of(CategoryMenu.KOREA_FOOD, false)
        );
    }
}