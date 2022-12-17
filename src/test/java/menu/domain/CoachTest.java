package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CoachTest {

    @DisplayName("이름이 2~4글자 사이가 아니면 예외가 발생한다")
    @ParameterizedTest
    @CsvSource({"한", "다섯글자임"})
    void nameTest(String name) {
        assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("못 먹는 음식이 2가지보다 많으면 예외를 발생한다.")
    @Test
    void sizeTest() {
        Coach coach = new Coach("포비");

        assertThatThrownBy(() -> coach.setBlacklist(List.of("쌈밥", "쌀국수", "탕수육")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("못 먹는 음식으면 True를 반환한다.")
    @ParameterizedTest
    @CsvSource({"쌈밥","쌀국수"})
    void blacklistTest(String name) {
        Coach coach = new Coach("포비");

        coach.setBlacklist(List.of("쌈밥", "쌀국수"));

        Assertions.assertThat(coach.isBlacklist(name)).isTrue();
    }
}