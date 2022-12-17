package menu.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class HateMenuTest {
    HateMenu hateMenu;

    @BeforeEach
    void initHateMenu() {
        List<String> menus = Arrays.asList("가츠동", "불고기");
        hateMenu = new HateMenu(menus);
    }

    @DisplayName("싫어하는 메뉴인지 확인하기 - 싫어하는 메뉴인 경우")
    @ValueSource(strings = {"가츠동", "불고기"})
    @ParameterizedTest
    void isHateMenuTest(String menu) {
        assertThat(hateMenu.isHateMenu(menu)).isTrue();
    }

    @DisplayName("싫어하는 메뉴인지 확인하기 - 싫어하는 메뉴가 아닌 경우")
    @ValueSource(strings = {"오니기리", "쌀국수", "마파두부"})
    @ParameterizedTest
    void isNotHateMenuTest(String menu) {
        assertThat(hateMenu.isHateMenu(menu)).isFalse();
    }


    @DisplayName("싫어하는 메뉴 추가 - 예외 데이터 입력")
    @Test
    void isHateMenu() {
        List<String> menus = Arrays.asList("test");
        assertThatThrownBy(() -> new HateMenu(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
