package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Menus 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class MenusTest {

    @Test
    void isInvalidMenu_메서드는_입력메뉴가_이미_존재하는_경우_true를_반환한다() {
        Menus menus = new Menus();
        menus.add(new Menu("음식"));

        boolean result = menus.isInvalidMenu(new Menu("음식"));

        Assertions.assertThat(result).isTrue();
    }
}
