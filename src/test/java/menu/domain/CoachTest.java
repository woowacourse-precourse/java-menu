package menu.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CoachTest {

    @DisplayName("이름이 2~4글자 사이가 아니면 예외가 발생한다")
    @ParameterizedTest
    @CsvSource({"한","다섯글자임"})
    void nameTest(String name) {
        assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}