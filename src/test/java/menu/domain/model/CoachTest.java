package menu.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CoachTest {

    private Coach coach;

    @BeforeEach
    void setUp() {
        List<Menu> menus = List.of(new Menu(Category.JAPAN_FOOD, "우동"),
                new Menu(Category.JAPAN_FOOD, "스시")
        );
        coach = new Coach("토미", menus);
    }

    @Test
    void 못먹는_메뉴인지_판단하는기능_테스트() {
        boolean result = coach.canEat(new Menu(Category.JAPAN_FOOD, "우동"));
        assertThat(result).isFalse();
    }

    @Test
    void 이름_길이가_2_4가아니면_예외발생() {
        List<Menu> menus = List.of(new Menu(Category.JAPAN_FOOD, "우동"),
                new Menu(Category.JAPAN_FOOD, "스시")
        );
        assertThatThrownBy(() -> coach = new Coach("항", menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 최소 2글자, 최대 4글지 이어야합니다.");
    }
}