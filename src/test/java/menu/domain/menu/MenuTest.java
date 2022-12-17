package menu.domain.menu;

import menu.domain.category.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Menu menu;
    
    @BeforeEach
    void setUp() {
        menu = new Menu("월남쌈", Category.ASIAN_FOOD);
    }
    
    @Test
    @DisplayName("같은 카테고리인지 확인")
    void isSameCategory() {
        assertThat(menu.isSameCategory(new Menu("카오 팟", Category.ASIAN_FOOD))).isTrue();
        assertThat(menu.isSameCategory(new Menu("김밥", Category.KOREAN_FOOD))).isFalse();
    }
    
    @Test
    void isSameMenuName() {
        assertThat(menu.isSameMenuName("월남쌈")).isTrue();
        assertThat(menu.isSameMenuName("카오 팟")).isFalse();
    }
}