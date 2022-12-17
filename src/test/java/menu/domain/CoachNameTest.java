package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CoachNameTest {
    @DisplayName("코치 이름이 2글자이상 4글자 이하가 아니면 예외처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"길", "홍길동홍길"})
    void createInvalidCoachName(String input) {
        Assertions.assertThatThrownBy(() -> CoachName.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("코치의 이름은 최소 2글자, 최대 4글자입니다.");
    }
}