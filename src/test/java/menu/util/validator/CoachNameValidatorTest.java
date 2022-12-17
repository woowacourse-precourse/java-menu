package menu.util.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import menu.util.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachNameValidatorTest {

    private CoachNameValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CoachNameValidator();
    }

    @Nested
    class invalidInputTest {

        @ParameterizedTest
        @ValueSource(strings = {"은기는천재", "우테코바보", "", "나"})
        @DisplayName("코치의 이름은 최소 2글자, 최대 4글자이다.")
        void 코치_이름_길이_테스트(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> validator.validate(input))
                    .withMessageStartingWith(ExceptionMessage.INVALID_COACH_NAME_LENGTH.getMessage());
        }
    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"은기", "우테코"})
        void 정상_입력(String input) {
            assertThatCode(() -> validator.validate(input))
                    .doesNotThrowAnyException();
        }
    }
}