package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuCategoriesOfDayTest {

    @DisplayName("같은 카테고리는 2번까지 가능하다")
    @Test
    void addTest() {
        MenuCategoriesOfDay categories = new MenuCategoriesOfDay();

        categories.put(Day.MONDAY, MenuCategory.KOREAN);
        assertThat(categories.canAdd(MenuCategory.KOREAN)).isTrue();

        categories.put(Day.TUESDAY, MenuCategory.KOREAN);
        assertThat(categories.canAdd(MenuCategory.KOREAN)).isTrue();

        categories.put(Day.WEDNESDAY, MenuCategory.KOREAN);
        assertThat(categories.canAdd(MenuCategory.KOREAN)).isFalse();

    }

}