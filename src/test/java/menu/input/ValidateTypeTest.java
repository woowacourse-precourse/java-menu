package menu.input;

import menu.type.ValidationType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidateTypeTest {

    @DisplayName("코치 인원 수에 따른 예외 테스트")
    @ValueSource(strings = {"1", "0", "6"})
    @ParameterizedTest
    void checkCoachSize_예외(String input) {
        boolean canRead = ValidationType.validate(ValidationType.CHECK_COACH_SIZE, input);
        assertThat(canRead).isFalse();
    }

    @DisplayName("코치 인원 수에 따른 정상 테스트")
    @ValueSource(strings = {"2", "3", "4", "5"})
    @ParameterizedTest
    void checkCoachSize_정상(String input) {
        boolean canRead = ValidationType.validate(ValidationType.CHECK_COACH_SIZE, input);
        assertThat(canRead).isTrue();
    }

    @DisplayName("코치 이름 길이에 따른 예외 테스트")
    @ValueSource(strings = {"1", "0", "5"})
    @ParameterizedTest
    void checkCoachNameSize_예외(String input) {
        boolean canRead = ValidationType.validate(ValidationType.CHECK_NAME_SIZE, input);
        assertThat(canRead).isFalse();
    }

    @DisplayName("코치 이름 길이에 따른 정상 테스트")
    @ValueSource(strings = {"2", "3", "4"})
    @ParameterizedTest
    void checkCoachNameSize_정상(String input) {
        boolean canRead = ValidationType.validate(ValidationType.CHECK_NAME_SIZE, input);
        assertThat(canRead).isTrue();
    }

    @DisplayName("메뉴 개수에 따른 예외 테스트")
    @ValueSource(strings = {"3"})
    @ParameterizedTest
    void checkMenuCount_예외(String input) {
        boolean canRead = ValidationType.validate(ValidationType.CHECK_MENUS_COUNT, input);
        assertThat(canRead).isFalse();
    }

    @DisplayName("메뉴 개수에 따른 정상 테스트")
    @ValueSource(strings = {"0", "1", "2"})
    @ParameterizedTest
    void checkMenuCount_정상(String input) {
        boolean canRead = ValidationType.validate(ValidationType.CHECK_MENUS_COUNT, input);
        assertThat(canRead).isTrue();
    }
}
