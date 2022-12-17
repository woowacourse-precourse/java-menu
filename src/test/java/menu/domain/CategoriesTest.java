package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategoriesTest {

    @Test
    @DisplayName("카테고리 추가 테스트")
    public void addCategoriesTest() {
        // given
        Categories categories = new Categories();
        String category1 = "한식";
        String category2 = "일식";

        // when
        categories.addCategory(category1);
        categories.addCategory(category2);

        // then
        assertThat(categories.getCategories()).isEqualTo(List.of(category1, category2));
    }

}
