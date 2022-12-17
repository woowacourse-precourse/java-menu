package menu.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import menu.domain.Categories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategoryGeneratorTest {
    private final CategoryGenerator categoryGenerator = new CategoryGenerator();

    @Test
    @DisplayName("카테고리 한 개 생성 테스트")
    public void generateCategoriesTest() {
        // given
        Categories categories = new Categories();

        // when
        categoryGenerator.generateCategories(categories);

        // then
        assertThat(categories.getCategories().size()).isEqualTo(1);
    }
}
