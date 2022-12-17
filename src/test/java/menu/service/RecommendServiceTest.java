package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.domain.FoodCategory;
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
        for (int i = 0; i <10; i++) {
            FoodCategory foodCategory = recommendService.recommendCategory();
            result.add(foodCategory);
        }
        //then
        Assertions.assertThat(result)
            .contains(FoodCategory.values());
    }
}
