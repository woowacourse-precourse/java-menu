package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Category 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class CategoryTest {

    @Test
    void from_메서드는_카테고리에_해당하는_숫자를_받으면_잘_생성된다() {
        assertThat(Category.from(1)).isEqualTo(Category.JAPANESE);
    }

    @Test
    void from_메서드는_카테고리에_해당하지_않는_숫자를_받으면_IEA_예외를_발생시킨다() {
        assertThatThrownBy(() -> Category.from(1000000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void from_메서드는_카테고리에_해당하는_단어를_받으면_잘_생성된다() {
        assertThat(Category.from("일식")).isEqualTo(Category.JAPANESE);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "일식아님")
    void from_메서드는_카테고리에_해당하지_않는_단어를_받으면_IEA_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> Category.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void toDto_메서드는_카테고리에_명칭에_해당하는_단어를_반환한다() {
        assertThat(Category.JAPANESE.toDto()).isEqualTo("일식");
    }
}
