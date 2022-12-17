package menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CoachTest {

    @Test
    @DisplayName("음식 고르기")
    void pickFood() {
        Coach coach = new Coach("name", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘"));
        String s = coach.pickMenu(Dish.pickCategory("일식"));

        assertThat(s).isEqualTo("오코노미야끼");
    }

    @Test
    @DisplayName("음식 고르기2")
    void pickFood2() {
        Coach coach = new Coach("name", List.of("aa", "bb"));
        String food = coach.pickMenu(List.of("aa", "bb", "cc"));

        assertThat(food).isEqualTo("cc");

    }
}
