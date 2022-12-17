package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.FoodCategory;
import menu.domain.Menu;
import menu.utils.MenuInitiator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RecommendServiceTest {

    @Test
    @DisplayName("같은 음식 카테고리 2번 넘게 추천하면 예외가 터진다")
    void recommendCategoryTest() {
        //given
        RecommendService recommendService = new RecommendService();
        //when
        recommendService.recommendCategory(1);
        recommendService.recommendCategory(1);
        //then
        Assertions.assertThatThrownBy(() -> recommendService.recommendCategory(1))
            .isInstanceOf(IllegalStateException.class);
    }
    
    @Test
    @DisplayName("랜덤 값 받아서 추천 확인 테스트")
    void recommendRandomTest() {
        //given
        RecommendService recommendService = new RecommendService();
        //when
        List<FoodCategory> result = new ArrayList<>();
        int max_day = 10;
        for (int i = 0; i < max_day; i++) {
            FoodCategory foodCategory = recommendService.recommendCategory();
            result.add(foodCategory);
        }
        //then
        Assertions.assertThat(result)
            .contains(FoodCategory.values());
    }

    @DisplayName("코치가 먹지 않는 음식은 추천하지 않는다.")
    @RepeatedTest(value = 10, name = "시도: {currentRepetition}/{totalRepetitions}")
    void recommendMenu() {
        //given
        Menu dislikeMenu = new Menu("김밥");
        Coach coach = new Coach("철수", List.of(dislikeMenu));
        MenuInitiator.init();
        RecommendService recommendService = new RecommendService();
        //when
        Menu recommendMenu = recommendService.recommendMenu(FoodCategory.KOREAN, coach);
        //then
        Assertions.assertThat(recommendMenu).isNotEqualTo(dislikeMenu);
    }
}
