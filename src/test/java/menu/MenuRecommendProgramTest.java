package menu;

import menu.menu.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MenuRecommendProgramTest {

    @DisplayName("모든 카테고리 선정 테스트")
    @Test
    void selectCategoryTest_1() {
        MenuRecommendProgram menuRecommendProgram = new MenuRecommendProgram();
        HashMap<String, Integer> countOfCategorySelected = new HashMap<>() {{
            for (Category category: Category.values()) {
                String categoryName = category.getCategoryName();
                put(categoryName, 0);
            }
        }};
        for (int i = 0; i < 10; i++) {
            String category = menuRecommendProgram.selectCategory();
            Integer countOfSelect = countOfCategorySelected.get(category);
            countOfCategorySelected.put(category, countOfSelect + 1);
        }

        for (String category: countOfCategorySelected.keySet()) {
            if (category.equals("카테고리 해당 없음")) {
                continue;
            }
            assertThat(countOfCategorySelected.get(category)).isEqualTo(2);
        }
    }
}
