package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CoachNameTest {

    @Test
    void coachName_Test() {
        assertThat(CoachName.of("안녕").getName()).isEqualTo("안녕");
    }

}