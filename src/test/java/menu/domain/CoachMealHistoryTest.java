package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("지금까지 코치들에게 추천된 메뉴 바탕으로 새로운 추천메뉴 가능한지 테스트")
class CoachMenuRecommendInfoTest {
    CoachMenuRecommendInfo coachMealHistory = new CoachMenuRecommendInfo();
    @ParameterizedTest
    @CsvSource(value = {"영호,밥,false","영호,국,true"})
    void 새로운_메뉴_추천_가능한지(String name, String menu, boolean result) {
        coachMealHistory.recommendMenu("영호","밥");
        Assertions.assertThat(coachMealHistory.isPossibleMenu(name, menu)).isEqualTo(result);
    }
}