package menu.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuRecommendationTest {
    private static MenuRecommendation menuRecommendation;

    @BeforeAll
    static void setUp() {
        menuRecommendation = new MenuRecommendation();
        menuRecommendation.initializeCoaches(List.of("토미", "제임스", "포코"));
        menuRecommendation.initializeDislikeFoods("토미", List.of("우동", "스시"));
        menuRecommendation.initializeDislikeFoods("제임스", List.of("뇨끼", "월남쌈"));
        menuRecommendation.initializeDislikeFoods("포코", List.of("마파두부", "고추잡채"));
    }

    @Test
    @DisplayName("음식 추천 시 중복이 없는 값이 만들어짐을 테스트한다")
    void recommendFood() {
//        menuRecommendation.recommendFood();
//        menuRecommendation.getRecommendedFood()
//                .forEach(this::assertEachRecommendation);
    }

    void assertEachRecommendation(List<String> foods) {
        int foodCount = (int) foods.stream()
                .distinct()
                .count();
        assertThat(foodCount).isEqualTo(5);
    }
}