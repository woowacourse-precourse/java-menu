package menu.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class CoachTest {
    private Coach coach;

    @BeforeEach
    void init() {
        coach = new Coach("구구");
        coach.setNoEatFood(List.of("감자", "고구마"));
        coach.addFood("딸기");
        coach.addFood("바나나");
    }

    @DisplayName("이미 추천된 메뉴이면 false 반환")
    @ValueSource(strings = {"딸기", "바나나"})
    @ParameterizedTest
    void duplicateMenu(String menu) {
        assertThat(coach.uniqueMenu(menu))
                .isEqualTo(false);
    }

    @DisplayName("못 먹는 메뉴이면 false 반환")
    @ValueSource(strings = {"감자", "고구마"})
    @ParameterizedTest
    void nonEatableMenu(String menu) {
        assertThat(coach.eatableMenu(menu))
                .isEqualTo(false);
    }

}
