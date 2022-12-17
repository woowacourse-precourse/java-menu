package menu.service;

import menu.model.Coach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RecommendService와 관련된 테스트를 진행한다")
class RecommendServiceTest {

    private static Coach coach;
    private static RecommendService recommendService;

    @BeforeEach
    void setup() {
        recommendService = new RecommendService();
        coach = new Coach("포비");
    }

    @Test
    void 메뉴_추천을_검증한다() {
        //when
        final List<String> recommendMenus = recommendService.findRecommendMenus(coach);

        //then
        assertThat(recommendMenus).hasSize(5);
    }

}