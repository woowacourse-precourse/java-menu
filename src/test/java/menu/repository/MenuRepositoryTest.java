package menu.repository;

import menu.controller.MenuController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuRepositoryTest {
    private MenuController menuController = new MenuController();
    private MenuRepository menuRepository = new MenuRepository();

    @Test
    void isExistsMenu() {
        boolean result = menuRepository.isExistsMenu("김밥");
        Assertions.assertThat(result).isTrue();
    }
}