package menu.domain.menu;

import menu.domain.category.Category;
import org.junit.jupiter.api.Test;

import java.util.jar.Manifest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuRepositoryTest {
    
    @Test
    void findByMenuName() {
        assertThat(MenuRepository.findByMenuName("월남쌈")).isEqualTo(new Menu("월남쌈", Category.ASIAN_FOOD));
    }
}