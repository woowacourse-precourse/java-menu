package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CoachTest {

    private Coach coach;

    @BeforeEach
    void setUp() {
        String name = "토미";
        List<String> canNotEatMenus = List.of("김치찌개");
        coach = new Coach(name, canNotEatMenus);
    }

    @Test
    void canEatTest() {
        assertThat(coach.canEat("김치찌개")).isFalse();
        assertThat(coach.canEat("쌈밥")).isTrue();
        assertThat(coach.canEat("쌈밥")).isFalse();
    }

    @Test
    void toStringTest() {
        coach.canEat("쌈밥");
        coach.canEat("미소시루");
        String expected = "[ 쌈밥 | 미소시루 ]";
        assertThat(coach.toString()).isEqualTo(expected);
    }
}