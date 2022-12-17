package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CategoryCountTest {

    CategoryCount categoryCount = new CategoryCount();

    @Test
    void canEatTest() {
        assertThat(categoryCount.canEat(Category.Korean)).isTrue();
        assertThat(categoryCount.canEat(Category.Korean)).isTrue();
        assertThat(categoryCount.canEat(Category.Korean)).isFalse();
    }

}