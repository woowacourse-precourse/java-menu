package menu.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        Assertions.assertThat(result).isFalse();
    }
}