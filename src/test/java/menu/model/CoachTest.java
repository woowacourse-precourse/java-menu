package menu.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoachTest {

    @DisplayName("중복된 메뉴가 선택되어 추천할 수 없다.")
    @Test
    public void unavailableMenuBecauseOfDuplicateMenu() {
        Coach coach = new Coach("test1");
        coach.addRecommendedMenu("김치찌개");

        Assertions.assertThat(coach.availableMenu("김치찌개"))
                .isEqualTo(false);
    }

    @DisplayName("먹지 못하는 메뉴가 선택되어 추천할 수 없다.")
    @Test
    public void unavailableMenuBecauseOfUnwantedMenu() {
        Coach coach = new Coach("test2");
        List<String> unwantedMenus = Arrays.asList("김밥", "떡볶이");
        coach.setUnwantedMenus(unwantedMenus);

        Assertions.assertThat(coach.availableMenu("김밥"))
                .isEqualTo(false);
        Assertions.assertThat(coach.availableMenu("떡볶이"))
                .isEqualTo(false);
        Assertions.assertThat(coach.availableMenu("김치찌개"))
                .isEqualTo(true);
    }

    @DisplayName("중복되지도, 못먹는 메뉴도 아니라 추천할 수 있다.")
    @Test
    public void availableMenu() {
        Coach coach = new Coach("test2");
        List<String> unwantedMenus = Arrays.asList("김밥, 떡볶이");
        coach.setUnwantedMenus(unwantedMenus);
        coach.addRecommendedMenu("김치찌개");

        Assertions.assertThat(coach.availableMenu("불고기"))
                .isEqualTo(true);
    }
}