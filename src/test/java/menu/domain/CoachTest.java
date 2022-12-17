package menu.domain;

import menu.domain.coach.Coach;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CoachTest {
    private final Coach woowa = Coach.from("우테코");

    @DisplayName("싫어하는 음식 추천 불가")
    @Test
    void hateMenus() {
        woowa.addHateMenu("피망");
        boolean result = woowa.canRecommend("피망");

        Assertions.assertThat(result).isFalse();
    }

    @DisplayName("음식 중복 추천 불가")
    @Test
    void recommendAgain() {
        woowa.recommend("초코");
        boolean result = woowa.canRecommend("초코");
        List<String> menus = woowa.getRecommendedMenus();
        List<String> expected = List.of("초코");

        Assertions.assertThat(result).isFalse();
        Assertions.assertThat(menus).isEqualTo(expected);
    }
}
