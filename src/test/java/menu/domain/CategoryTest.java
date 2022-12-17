package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CategoryTest {

    @DisplayName("존재하는 카테고리면 해당 카테고리를 반환한다.")
    @ValueSource(strings = {"일식", "한식", "중식", "아시안", "양식"})
    @ParameterizedTest
    void fromName(String name) {
        Category category = Category.from(name);

        assertThat(category.getName()).isEqualTo(name);
    }

    @DisplayName("존재하지 않는 카테고리면 예외를 발생시킨다.")
    @ValueSource(strings = {"브라질", "영국", "캐나다", "미국", "호주"})
    @ParameterizedTest
    void fromNameWithException(String name) {
        assertThatThrownBy(() -> Category.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하는 값이면 해당 카테고리를 반환한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void fromValue(int value) {
        Category category = Category.from(value);

        assertThat(category.getValue()).isEqualTo(value);
    }

    @DisplayName("존재하지 않는 값이면 예외를 발생시킨다.")
    @ValueSource(ints = {6, 7, 8, 9, 10})
    @ParameterizedTest
    void fromValueWithException(int value) {
        assertThatThrownBy(() -> Category.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}