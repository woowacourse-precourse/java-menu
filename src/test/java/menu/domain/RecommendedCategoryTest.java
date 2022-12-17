package menu.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecommendedCategoryTest {
    private RecommendedCategory recommendedCategory;

    @BeforeEach
    void setUp() {
        recommendedCategory = new RecommendedCategory();
    }

    @Test
    @DisplayName("카테고리가 최대 2회까지만 중복 됨을 테스트한다")
    void checkCategoryOnlyDuplicateLessThan2() {
        int count = 0;
        while (count < 5) {
            recommendedCategory.pickRandomCategory();
            count++;
        }

        recommendedCategory.getCategories()
                .forEach(this::assertEachCategory);
    }

    void assertEachCategory(String category) {
        assertThat(recommendedCategory.getCategories()
                .stream().filter(nowCategory -> nowCategory.equals(category))
                .count()).isLessThanOrEqualTo(2);
    }

}