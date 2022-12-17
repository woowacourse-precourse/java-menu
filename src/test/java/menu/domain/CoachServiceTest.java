package menu.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class CoachServiceTest {

    private CoachService coachService = new CoachService();

    @Test
    void registerCannotEatFoods() {
        Coach coach = new Coach("정우");
        coachService.registerCannotEatFoods(coach,"규동");
        assertThat(coach.getCannotEatFoods().get(0)).isEqualTo("규동");
    }
}