package domain;

import menu.domain.Coach;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoachTest {

    @Test
    void 코치_생성_테스트() {
        Coach coach = Coach.createCoach("두부");
        Assertions.assertThat(coach).isInstanceOf(Coach.class);
    }

    @Test
    void 코치_생성_예외_테스트() {
        Assertions.assertThatThrownBy(() -> Coach.createCoach("두"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Coach.createCoach("두부부부부"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
