package menu.repository;

import static org.assertj.core.api.Assertions.*;

import menu.domain.Coach;
import org.junit.jupiter.api.Test;

class CoachRepositoryTest {

    @Test
    void isUniqueName() {
        assertThat(CoachRepository.isUniqueName("크룽")).isTrue();
        CoachRepository.addCoaches(new Coach("크롱"));
        assertThat(CoachRepository.isUniqueName("크롱")).isFalse();
    }
}