package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {
    @Test
    @DisplayName("못먹는 음식이 포함되어 있는지 확인하는 함수 테스트")
    void checkIsInEdibleMenuTest() {
        List<String> inEdibleMenu = List.of("짬뽕","짜장면");
        List<String> nowMenu = List.of("마파두부","고추잡채");
        String menu_1 = "짬뽕";
        String menu_2 = "탕수육";
        String menu_3 = "고추잡채";

        assertThat(Menu.isInEdibleMenu(inEdibleMenu, menu_1,nowMenu)).isEqualTo(true);
        assertThat(Menu.isInEdibleMenu(inEdibleMenu, menu_2,nowMenu)).isEqualTo(false);
        assertThat(Menu.isInEdibleMenu(inEdibleMenu, menu_3,nowMenu)).isEqualTo(true);
    }
}
