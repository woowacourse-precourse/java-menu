package menu.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CategoryTest {
    @Test
    void 카테고리_랜덤_선택_지정되지않은값_예외발생() {
        assertThatThrownBy(() -> Category.takeRandomCategory(6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}