package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FoodCategoryTest {

    @DisplayName("카테고리 숫자로 해당하는 카테고리를 생성한다")
    @ParameterizedTest
    @CsvSource({"1,JAPANESE", "2,KOREAN", "3,CHINESE", "4,ASIAN", "5,WESTERN"})
    void createCategory(int categoryNumber, FoodCategory category) {
        assertThat(FoodCategory.of(categoryNumber)).isEqualTo(category);
    }

}