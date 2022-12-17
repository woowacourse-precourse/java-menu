package menu.domain;

import org.assertj.core.api.Assertions;
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
        List<Category> categories = List.of(Category.JAPAN, Category.KOREA, Category.CHINA, Category.ASIAN, Category.WEST);

        assertThat(Category.getCategory(index)).isEqualTo(categories.get(index - 1));
    }
}