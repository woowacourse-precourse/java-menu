package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {
    @Test
    @DisplayName("있는 메뉴 찾는 경우")
    void containsMenu_ValidMenu_ReturnTrue() {
        assertThat(MenuRepository.containsMenu("우동")).isEqualTo(true);
    }

    @Test
    @DisplayName("없는 메뉴 찾는 경우")
    void containsMenu_InvalidMenu_ReturnFalse() {
        assertThat(MenuRepository.containsMenu("우동면")).isEqualTo(false);
    }
}