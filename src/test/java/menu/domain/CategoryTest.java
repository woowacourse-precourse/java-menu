package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void findByCategory_test() {
        assertThat(Category.findCategory("일식")).isEqualTo(Category.JAPANESE);
    }

}