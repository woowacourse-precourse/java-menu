package menu.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void from_메소드는_일치하는코드가_없으면_예외() {
        Assertions.assertThatThrownBy(() -> {
                    Category.from(20);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CATEGORY_NOT_FOUND.getMessage());
    }
}