package menu.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
}
