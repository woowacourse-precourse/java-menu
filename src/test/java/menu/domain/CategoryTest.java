package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CategoryTest {

    @ParameterizedTest
    @DisplayName("카테고리 찾기")
    @CsvSource(value = {
            "1,JAPAN",
            "2,KOREAN",
            "3,CHINA",
            "4,ASIAN",
            "5,AMERICAN"
    })
    void findCategory(int index, Category category) {

        assertThat(Category.findCategory(index)).isEqualTo(category);
    }

    @Test
    @DisplayName("없는 번호일때 카테고리 예외")
    void notExistCategory() {

        assertThatThrownBy(() -> Category.findCategory(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Category.findCategory(6)).isInstanceOf(IllegalArgumentException.class);
    }
}
