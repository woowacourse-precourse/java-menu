package menu.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import menu.domain.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {

    @AfterEach
    void after() {
        MenuRepository.clear();
    }

    @DisplayName("메뉴를 저장하고 확인한다.")
    @Test
    void storeMenu() {
        Category category = Category.KOREA;
        String menu = "김치";

        MenuRepository.addMenu(category, menu);
        List<String> menus = MenuRepository.findByCategory(category);

        assertThat(menus.size()).isEqualTo(1);
        assertThat(menus).containsExactly(menu);
    }

    @DisplayName("중복되는 메뉴는 저장되지 않는다.")
    @Test
    void storeDuplicationMenu() {
        Category category = Category.KOREA;
        String menu = "김치";

        MenuRepository.addMenu(category, menu);
        MenuRepository.addMenu(category, menu);
        List<String> menus = MenuRepository.findByCategory(category);

        assertThat(menus.size()).isEqualTo(1);
        assertThat(menus).containsExactly(menu);
    }

    @DisplayName("초기화하면 아무것도 남아있지 않는다.")
    @Test
    void clear() {
        Category category = Category.KOREA;
        String menu = "김치";

        MenuRepository.addMenu(category, menu);
        MenuRepository.clear();
        List<String> menus = MenuRepository.findByCategory(category);

        assertThat(menus.size()).isEqualTo(0);
    }
}