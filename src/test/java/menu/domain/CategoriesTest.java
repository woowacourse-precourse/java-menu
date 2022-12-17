package menu.domain;

import menu.util.TestNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoriesTest {

    //0~4를 순서대로 반환하는 TestNumberGenerator 즉, 카테고리가 순서대로 하나씩 나와야한다.
    private static Categories categories = new Categories(new TestNumberGenerator());

    @Test
    void getRecommendCategory() {
        List<Category> recommendCategory = categories.getRecommendCategory();
        boolean check = false;
        for (int i = 0; i < recommendCategory.size(); i++) {
            if (recommendCategory.get(i) != Category.getCategories().get(i)) {
                check = true;
            }
        }
        Assertions.assertThat(check).isEqualTo(false);
    }
}