package menu.domain.repository;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import menu.domain.Category;
import menu.util.ExceptionMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryRepositoryTest {

    public static final Category KOREAN_CATEGORY = new Category("한식");
    public static final Category JAPANESE_CATEGORY = new Category("일식");

    @BeforeEach
    void setUp() {
        CategoryRepository.removeAll();
    }

    @Test
    @DisplayName("2회 이상 추천한 카테고리는 추천하지 않는다.")
    void categoryCountTest() {
        CategoryRepository.updateCategoriesAlreadyEaten(KOREAN_CATEGORY);
        CategoryRepository.updateCategoriesAlreadyEaten(KOREAN_CATEGORY);
        CategoryRepository.updateCategoriesAlreadyEaten(JAPANESE_CATEGORY);

        Assertions.assertFalse(CategoryRepository.isAvailableCategory(KOREAN_CATEGORY));
        Assertions.assertTrue(CategoryRepository.isAvailableCategory(JAPANESE_CATEGORY));
        Assertions.assertEquals(List.of(KOREAN_CATEGORY, KOREAN_CATEGORY, JAPANESE_CATEGORY),
                CategoryRepository.getCategoriesAlreadyEaten());
    }

    @Test
    @DisplayName("존재하지 않는 카테고리를 입력하는 경우 예외 처리한다..")
    void categoryFindTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CategoryRepository.findCategoryByName("없는 카테고리"))
                .withMessageStartingWith(ExceptionMessage.NO_SUCH_CATEGORY.getMessage());
    }

    @AfterEach
    void afterAll() {
        CategoryRepository.removeAll();
    }
}