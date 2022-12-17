package menu;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.view.InputValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 입력값이_비어_있거나_스페이스만_있다면_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> inputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 값이 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"one", "!", "오므라이ㅅ", "5므라이스", "ㅉr장면"})
    void 입력값이_완성된_한글_외의_값이_포함되어_있다면_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> inputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한글을 올바르게 입력해주세요.");
    }
}