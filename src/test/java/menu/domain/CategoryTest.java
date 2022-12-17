package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Category Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CategoryTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 6})
    void of_메서드는_올바르지_않은_숫자를_입력하는경우_IllegalArugmentException을_던진다(Integer number) {
        assertThatThrownBy(() -> Category.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 카테고리입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1, JAPAN", "2, KOREA", "3, CHINA", "4, ASIAN", "5, WESTERN"})
    void of_메서드는_올바른_숫자를_입력하는경우_카테고리_인스턴스를_반환한다(Integer number, Category result) {
        Category category = Category.of(number);

        assertThat(category).isEqualTo(result);
    }

    @Test
    void generateRandomCategories_메서드는_입력받은_숫자만큼의_카테고리_리스트를_반환한다() {
        List<Category> categories = Category.generateRandomCategories(5);

        assertThat(categories).hasSize(5);
    }

}
