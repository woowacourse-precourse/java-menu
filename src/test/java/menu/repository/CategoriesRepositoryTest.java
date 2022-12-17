package menu.repository;

import java.util.List;
import menu.domain.Categories;
import menu.domain.enums.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class CategoriesRepositoryTest {

    @DisplayName("카테고리 정상 생성 테스트")
    @RepeatedTest(100)
    void generateCategories() {
        // given
        // when
        Categories categories = CategoriesRepository.generateCategories();
        List<Category> generateCategories = categories.getCategories();
        System.out.println(generateCategories);
    }
}