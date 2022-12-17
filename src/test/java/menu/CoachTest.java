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
        String s = coach.pickFood(Dish.pickCategory(1));

        assertThat(s).isEqualTo("오코노미야끼");
    }
}
