package menu.service;

import menu.exception.NoSuchMenuException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MenuServiceTest {
    @DisplayName("메뉴 존재 여부 확인")
    @Test
    void validateMenuExist() {
        Assertions.assertThatThrownBy(() -> {
            MenuService menuService = new MenuService();
            menuService.validateMenusExist(List.of("존재하지 않는 음식"));
        }).isInstanceOf(NoSuchMenuException.class);
    }
}
