package menu.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class CoachServiceTest {

    private CoachService coachService = new CoachService();

    @Test
    void registerCoachesValidateByCoachNum() {
        coachService.registerCoaches("포비,제이슨,김정우");
        assertThat(CoachRepository.coaches().size()).isEqualTo(3);
    }
}