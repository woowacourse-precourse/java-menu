package menu.model;

import menu.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    @DisplayName("입력한 코치가 2명 미만일 때 예외 발생")
    @ValueSource(strings = {"토미", ""})
    @ParameterizedTest
    void lessCoach(String input) {
        assertThatThrownBy(() -> Validator.validateCoach(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.COACH_MIN.getMessage());
    }

    @DisplayName("입력한 코치가 5명 초과일 때 예외 발생")
    @Test
    void moreCoach() {
        String input = "토미,제임스,포코,미미,주디,안나";
        assertThatThrownBy(() -> Validator.validateCoach(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.COACH_MAX.getMessage());
    }

    @DisplayName("입력한 코치 이름이 2글자 미만일 때 예외 발생")
    @ValueSource(strings = {"김,이", "포코,김"})
    @ParameterizedTest
    void shortName(String input) {
        assertThatThrownBy(() -> Validator.validateCoach(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NAME_MIN.getMessage());
    }

    @DisplayName("입력한 코치 이름이 4글자 초과일 때 예외 발생")
    @ValueSource(strings = {"김안드레아스,포코", "구구,구구구구,구구구구구"})
    @ParameterizedTest
    void longName(String input) {
        assertThatThrownBy(() -> Validator.validateCoach(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NAME_MAX.getMessage());
    }
}
