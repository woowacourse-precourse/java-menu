package menu.domain;

import menu.domain.coach.Coach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CoachTest {
    @Test
    public void coach_test() {
        Coach coach = Coach.of("뽀삐");
        coach.initFoods(List.of("짬뽕"));

        assertThat(1).isEqualTo(coach.getFoods().size());
    }
}
