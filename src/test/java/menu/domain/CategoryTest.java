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
        Category category = new Category();
        Integer value = category.recommandDayCategory();
        assertThat(value).isGreaterThanOrEqualTo(1);
        assertThat(value).isLessThanOrEqualTo(5);
    }
}
