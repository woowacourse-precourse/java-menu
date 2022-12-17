package menu.view;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @ParameterizedTest(name = "사용자 입력 : {0}이면 길이가 2 ~ 5 사이이다.")
    @ValueSource(strings = {"토미,제임스", "토미,제임스,포코,나나,니니"})
    void validateCoachNames_메서드는_사용자_입력을_받아_길이_맞는지_확인한다(String names) {
        assertThatNoException().isThrownBy(() -> {
            InputValidator.validateCoachNames(names);
        });
    }

    @ParameterizedTest(name = "사용자 입력 : {0}이면 예외 던진다.")
    @ValueSource(strings = {"토미", "토미,제임스,포코,나나,니니,구구", "토미,토미"})
    void validateCoachNames_메서드는_사용자_입력을_받아_예외_확인한다(String names) {
        assertThatThrownBy(() -> {
            InputValidator.validateCoachNames(names);
        });
    }

    @ParameterizedTest(name = "사용자 입력 : {0}이면 길이가 0 ~ 2 사이이다.")
    @ValueSource(strings = {"완자,비빔밥", "", "완자"})
    void validateNoEat_메서드는_사용자_입력을_받아_길이_맞는지_확인한다(String names) {
        assertThatNoException().isThrownBy(() -> {
            InputValidator.validateNoEat(names);
        });
    }

    @ParameterizedTest(name = "사용자 입력 : {0}이면 예외 던진다.")
    @ValueSource(strings = {"완자,완자", "완자,비빔밥,육수"})
    void validateNoEat_메서드는_사용자_입력을_받아_예외_확인한다(String names) {
        assertThatThrownBy(() -> {
            InputValidator.validateNoEat(names);
        });
    }
}