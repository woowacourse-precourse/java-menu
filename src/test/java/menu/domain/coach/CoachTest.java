package menu.domain.coach;

import java.util.List;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "코치코치코"})
    public void 코치_이름은_2글자에서_4글자_사이만_가능하다(String input) {
        Assertions.assertThatThrownBy(() -> Coach.fromName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 못_먹는_음식_조회_테스트() {
        Coach coach = Coach.fromName("코치");
        Menu uDon = Menu.of("우동", MenuCategory.JAPANESE);
        coach.addAllAvoidMenu(List.of(
                Menu.of("김치찌개", MenuCategory.KOREAN),
                uDon
        ));

        Assertions.assertThat(coach.isAvoidMenu(uDon)).isTrue();
    }


}