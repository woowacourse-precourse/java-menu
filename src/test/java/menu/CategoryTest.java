package menu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import menu.Model.Category;

public class CategoryTest {
    @DisplayName("카테고리 예외 테스트 - 음식이 메뉴에 없는 경우")
    @ValueSource(strings = { "스테이크", "나베", "라면" })
    @ParameterizedTest
    public void checkFoodInMenusTest(String input) {
        assertThat(Category.checkFoodInMenus(input))
                .isEqualTo(false);
    }

    @DisplayName("순서가 주어질 때, 카테고리 반환 테스트")
    @ValueSource(ints = { 1 })
    @ParameterizedTest
    public void getCategoryFromNumberTest(int input) {
        assertThat(Category.getCategoryFromNumber(input))
                .isEqualTo(Category.JAPANESE);
    }
}
