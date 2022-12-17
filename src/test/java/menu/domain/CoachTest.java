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
    void requestFormatTest() {
        coach.canEat("비빔밥");
        coach.canEat("탕수육");
        assertThat(coach.requestFormat().get(0)).isEqualTo("토미");
        assertThat(coach.requestFormat().get(1)).isEqualTo("비빔밥");
        assertThat(coach.requestFormat().get(2)).isEqualTo("탕수육");
    }

}