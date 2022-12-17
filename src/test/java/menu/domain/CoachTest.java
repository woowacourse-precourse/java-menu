package menu.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"뿌","뿌우우우우"})
    @DisplayName("코치 이름 길이는 2~4글자 이내만 허용")
    void 코치_이름길이_유효성_검증(String name){
        assertThatThrownBy(
            () -> new Coach(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}