package menu.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @CsvSource({"한", "식일식중식"})
    void validateCoachNameTest(String coachName) {
        assertThatThrownBy(() -> inputValidator.validateCoachName(coachName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("코치 이름은 2글자 이상 4글자 이하입니다.");
    }

    @Test
    void validateCoachNamesLength() {
        List<String> coachNames = List.of("토미");
        assertThatThrownBy(() -> inputValidator.validateCoachNamesLength(coachNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("코치는 2명 이상 5명 이하입니다.");
    }

}