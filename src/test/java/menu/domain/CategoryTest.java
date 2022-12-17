package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryTest {
    @Test
    @DisplayName("카테고리를 추천하는 함수 테스트")
    void checkRecommandMenuCategoryTest() {
        List<Integer> category = Category.recommandCategory();
        assertThat(category.size()).isEqualTo(5);

        for (int i = 1; i <=5; i++)
            assertThat(Collections.frequency(category,i)).isLessThan(2);
    }
}
