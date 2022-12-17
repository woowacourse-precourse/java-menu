package menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import menu.coach.Coach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @DisplayName("Normal BridgeSize")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(strings = {"토비", "토토토비"})
    void Validate_BridgeSize_exception(String input) {
        assertThat(new Coach(input).getName()).isEqualTo(input);
    }

    @DisplayName("Unvalidated BridgeSize Range")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(strings = {"토", "토토토토토"})
    void Unvalidated_BridgeSize_exception(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Coach(input);
        });
        assertEquals(exception.getMessage(), "코치의 이름은 2~4 글자 입니다.");
    }
}