package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecommendCategoryMakerTest {
    
    private final RecommendCategoryMaker recommendCategoryMaker =
            new RecommendCategoryMaker(new RandomNumberGenerator());

    @DisplayName("5개의 카테고리를 생성한다.")
    @Test
    void test1() {
        List<Category> categories = recommendCategoryMaker.make();

        assertThat(categories.size()).isEqualTo(5);
    }
}