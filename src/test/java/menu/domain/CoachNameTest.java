package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "a", "abcde"})
    void 코치의_이름_글자수가_제한된_숫자를_넘으면_예외를_발생시키는지_테스트(String name) {
        assertThatThrownBy(() -> new CoachName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}