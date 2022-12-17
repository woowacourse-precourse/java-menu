package menu.model;

import menu.constants.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SelectCategoryTest {
    SelectCategory selectCategory = new SelectCategory();

    @BeforeEach
    void initSelectCategory() {
        List<Category> categories = Arrays.asList(Category.ASIAN_FOOD, Category.ASIAN_FOOD,
                Category.KOREAN_FOOD);
        for (Category category : categories) {
            selectCategory.addCategory(category);
        }
    }

    @DisplayName("두 번 이상 선택된 카테고리인지 확인하기 - 두 번 이상 선택된 경우")
    @Test
    void isFrequencyMoreThanTwoTest() {
        assertThat(selectCategory.isFrequencyMoreThanTwo(Category.ASIAN_FOOD)).isTrue();
    }

    @DisplayName("두 번 이상 선택된 카테고리인지 확인하기 - 두 번 이상 선택하지 않은 경우")
    @MethodSource("generateCategory")
    @ParameterizedTest
    void isNotFrequencyMoreThanTwoTest(Category category) {
        assertThat(selectCategory.isFrequencyMoreThanTwo(category)).isFalse();
    }

    static Stream<Arguments> generateCategory() {
        return Stream.of(
                Arguments.of(Category.CHINESE_FOOD),
                Arguments.of(Category.KOREAN_FOOD),
                Arguments.of(Category.JAPANESE_FOOD),
                Arguments.of(Category.WESTERN_FOOD)
        );
    }

    @DisplayName("선택 카테고리 가져오기 테스트")
    @Test
    void getSelectCategoriesTest() {
        List<String> expectResult = Arrays.asList("아시안","아시안", "한식");
        List<Category> categories = selectCategory.getSelectCategories();

        for (int i = 0; i < categories.size(); i++) {
            assertThat(categories.get(i).getCategory()).isEqualTo(expectResult.get(i));
        }
    }


    @DisplayName("출력을 위한 선택 카테고리 가져오기 테스트")
    @Test
    void getSelectCategoryForPrintTest() {
        List<String> expectResult = Arrays.asList("카테고리", "아시안","아시안", "한식");
        List<String> categories = selectCategory.getSelectCategoryForPrint();

        for (int i = 0; i < categories.size(); i++) {
            assertThat(categories).isEqualTo(expectResult);
        }
    }
}
