package menu.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"토미,제임스,포코,", "토미토미토, 제임스제", ", ", "토,제임스", "토미,제임스,포코,포코코,포라,라면"})
    void validateCoachName_메서드는_올바르지_않은_코치명을_입력했을때_IllegalArgumentExcpetion을_던진다(String names) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateCoachName(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"토미,제임스,포코", "토미,포코", "일커피,이커피,삼커피,사커피,오커피", "토미,제임스,포코코,포라,라면"})
    void validateCoachName_메서드는_올바른_코치명을_입력하면_예외를_던지지_않는다(String names) {
        Assertions.assertThatNoException().isThrownBy(() -> InputValidator.validateCoachName(names));
    }

    @ParameterizedTest
    @ValueSource(strings = {"계란,김치,떡국"})
    void validateMenuNames_메서드는_올바르지_않은_메뉴명을_입력했을때_IllegalArgumentExcpetion을_던진다(String names) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateMenuNames(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "계란", "계란,김치"})
    void validateMenuNames_메서드는_올바른_메뉴명을_입력하면_예외를_던지지_않는다(String names) {
        Assertions.assertThatNoException().isThrownBy(() -> InputValidator.validateMenuNames(names));
    }
}
