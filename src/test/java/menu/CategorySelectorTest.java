package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CategorySelectorTest {

    @Test
    @DisplayName("두번만 뽑는지 확인")
    void test() {
        CategorySelector categorySelector = new CategorySelector();
        for (int i = 0; i < 10; i++) {
            categorySelector.pickCategory();
        }
        long count = categorySelector.getCategoryRepository().stream().filter(s -> s.equals("중식")).count();
        long count2 = categorySelector.getCategoryRepository().stream().filter(s -> s.equals("양식")).count();
        assertThat(count).isEqualTo(count2).isEqualTo(2);
    }
}
