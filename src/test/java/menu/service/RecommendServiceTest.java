package menu.service;

import menu.model.Coach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("RecommendService와 관련된 테스트를 진행한다")
class RecommendServiceTest {

    private static Coach coach;
    private static RecommendService recommendService;

    @BeforeEach
    void setup() {
        recommendService = new RecommendService();
        coach = new Coach("포비");
    }
}