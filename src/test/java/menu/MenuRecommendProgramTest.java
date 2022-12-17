package menu;

import menu.coach.Coach;
import menu.menu.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @DisplayName("이미 먹은 메뉴나 먹지 못하는 메뉴는 추천하지 않는다.")
    @Test
    void selectMenuTest() {
        MenuRecommendProgram menuRecommendProgram = new MenuRecommendProgram();
        Coach coach = new Coach("한빈");
        coach.addFoodNotEat("스시");
        List<String> notEatFoods = new ArrayList<>();
        notEatFoods.add("스시");

        for (int i = 0; i < 8; i++) {
            String menu = menuRecommendProgram.selectMenu(coach, "일식");
            assertThat(notEatFoods.contains(menu)).isFalse();
            notEatFoods.add(menu);
        }
    }
}
