package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CategoryTest {


    @DisplayName("1~5에 해당하는 인덱스는 일식, 한식, 중식, 아시안, 양식이다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void createCategoryIndex(int index) {
        // given
        List<Category> categories = List.of(Category.JAPAN, Category.KOREA, Category.CHINA, Category.ASIAN, Category.WEST);

        // when, then
        assertThat(Category.getCategory(index)).isEqualTo(categories.get(index - 1));
    }

    @DisplayName("2번 추천된 카테고리는 추천할 수 없다.")
    @Test
    void createOverCategoryCount() {
        // given
        Category.KOREA.addCount();
        Category.KOREA.addCount();

        // when, then
        assertThat(Category.KOREA.canChoose()).isEqualTo(false);
    }

    @DisplayName("2번 이하로 추천된 카테고리는 추천할 수 있다.")
    @Test
    void createUnderCategoryCount() {
        // given
        Category.JAPAN.addCount();

        // when, then
        assertThat(Category.JAPAN.canChoose()).isEqualTo(true);
    }
}