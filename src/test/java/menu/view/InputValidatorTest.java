package menu.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @CsvSource({"한", "식일식중식"})
    void validateCoachNameTest(String coachName) {
        assertThatThrownBy(() -> inputValidator.validateCoachName(coachName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("코치 이름은 2글자 이상 4글자 이하입니다.");
    }

}