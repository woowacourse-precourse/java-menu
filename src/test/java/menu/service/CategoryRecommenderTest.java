package menu.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class CategoryRecommenderTest {

    CategoryRecommender categoryRecommender;

    @BeforeEach
    void beforeEach() {
        categoryRecommender = new CategoryRecommender();
    }


    @RepeatedTest(20)
    void 한_주에_같은_카테고리는_3회이상_골라지지않는다() {
        List<Category> categories = new ArrayList<>();
        Category category = categoryRecommender.pickOneCategory(categories);
        categories.add(category);
        categories.add(category);
        assertThat(categoryRecommender.pickOneCategory(categories)
        ).isNotEqualTo(category);
    }
}