package menu;

import menu.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryRandomRecommenderTest {

    CategoryRandomRecommender categoryRandomRecommender;
    List<Category> categories;

    @BeforeEach
    void init() {
        categoryRandomRecommender = new CategoryRandomRecommender();
        categories = List.of(Category.KOREAN, Category.WESTERN, Category.KOREAN);
    }

    @DisplayName("이미 두 번 추천된 카테고리는 다시 추천되지 않는다.")
    @Test
    void recommend() {
        Category recommend;
        for (int i = 0; i < 5; i++) {
            recommend = categoryRandomRecommender.recommend(categories);
            assertThat(recommend).isNotEqualTo(Category.KOREAN);
        }
    }
}