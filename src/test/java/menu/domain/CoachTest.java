package menu.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {

    private static final Coach eunkeeee = new Coach("은기");
    private static final Menu menuNotToEat = new Menu("김치");
    private static final Menu alreadyEatenMenu = new Menu("사케동");
    private static final Menu availableMenu = new Menu("가능한 메뉴");


    @Test
    @DisplayName("이미 먹은 메뉴는 추천하지 않는다.")
    void 이미_먹은_메뉴_추천_테스트() {
        eunkeeee.addMenuNotToEat(List.of(menuNotToEat));
        eunkeeee.addMenuAlreadyEaten(Day.FRIDAY, alreadyEatenMenu);

        Assertions.assertFalse(eunkeeee.isAvailableMenu(menuNotToEat));
        Assertions.assertFalse(eunkeeee.isAvailableMenu(alreadyEatenMenu));
        Assertions.assertTrue(eunkeeee.isAvailableMenu(availableMenu));
    }
}