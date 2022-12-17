package menu.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import menu.domain.initialdata.InitialMenu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecommendedFoodTest {
    private static RecommendedFood recommendedFood;
    private static List<String> dislike;
    private static String category;

    @BeforeAll
    static void setUp() {
        recommendedFood = new RecommendedFood();
        dislike = List.of("똠양꿍", "분짜", "팟타이");
        category = "아시안";

        int count = 0;
        while (count < 5) {
            recommendedFood.pickRecommendedFood(InitialMenu.getFoodsInCategory(category), dislike);
            count++;
        }
    }

    @Test
    @DisplayName("못 먹는 음식의 포함 여부를 체크한다")
    void checkDislikeNotIncluded() {
        assertThat(recommendedFood.getFoods()).doesNotContainAnyElementsOf(dislike);
        //중복된 음식 체크
        //카테고리에 맞는 음식 체킄
    }

    @Test
    @DisplayName("중복된 음식을 체크한다")
    void checkNoneDuplicate() {
        assertThat(recommendedFood.getFoods()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("카테고리에 맞는 음식을 체크한다")
    void checkCorrectCategory() {
        recommendedFood.getFoods()
                .forEach(food -> assertThatFoodIsInCategory(InitialMenu.getFoodsInCategory(category), food));
    }

    void assertThatFoodIsInCategory(List<String> categoryFoods, String food) {
        assertThat(categoryFoods).contains(food);
    }
}