package menu.domain;

import menu.domain.coach.Menus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MenusTest {
    @DisplayName("메뉴가 있는지 확인")
    @Test
    void doNotHasMenu() {
        Menus menus = Menus.generate();
        menus.add("카레");

        Assertions.assertThat(menus.doNotHas("카레")).isFalse();
    }

    @DisplayName("메뉴 추가")
    @Test
    void addMenu() {
        Menus menus = Menus.generate();
        menus.add("피망");

        List<String> result = menus.getAll();
        List<String> expected = List.of("피망");

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
