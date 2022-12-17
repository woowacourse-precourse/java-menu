package menu.repository;

import menu.controller.MenuController;
import menu.domain.Category;
import menu.domain.Menus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuRepositoryTest {
    private MenuController menuController = new MenuController();
    private MenuRepository menuRepository = new MenuRepository();

    @Test
    void isExistsMenu() {
        boolean result = menuRepository.isExistsMenu("김밥");
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("일식 카테고리의 메뉴를 확인한다.")
    @Test
    void findByCategory() {
        Menus result = menuRepository.findByCategory(Category.JAPANESE);
        Assertions.assertThat(result).extracting("menus").isEqualTo(List.of("규동", "우동", "미소시루", "스시",
                "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
    }
}