package menu.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SelectMenuTest {
    SelectMenu selectMenu = new SelectMenu();

    @BeforeEach
    void initSelectMenu() {
        List<String> menus = Arrays.asList("불고기", "라멘");
        for (String menu : menus) {
            selectMenu.addMenu(menu);
        }
    }

    @DisplayName("이미 선택된 메뉴인지 확인하기 - 이미 선택된 메뉴인 경우")
    @ValueSource(strings = {"불고기", "라멘"})
    @ParameterizedTest
    void isAlreadyExist(String menu) {
        assertThat(selectMenu.isAlreadyExist(menu)).isTrue();
    }

    @DisplayName("이미 선택된 메뉴인지 확인하기 - 이미 선택된 메뉴가 아닌 경우")
    @ValueSource(strings = {"오니기리", "쌀국수", "마파두부"})
    @ParameterizedTest
    void isNotAlreadyExist(String menu) {
        assertThat(selectMenu.isAlreadyExist(menu)).isFalse();
    }

    @DisplayName("선택된 메뉴 가져오기 테스트")
    @Test
    void getSelectMenu() {
        assertThat(selectMenu.getSelectMenu()).isEqualTo(Arrays.asList("불고기", "라멘"));
    }
}
