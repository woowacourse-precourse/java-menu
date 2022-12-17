package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("CategoryPicker 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CategoryPickerTest {

    private final CategoryPicker categoryPicker = new CategoryPicker(new RandomPicker());

    @Test
    void pick_메서드는_category_enum_중_하나를_반환한다() {
        assertThat(categoryPicker.pickCategory()).isInstanceOf(Category.class);
    }
}
