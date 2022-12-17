package menu;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import menu.Model.Coach;

public class CoachTest {
    @DisplayName("코치 이름 예외 테스트 - 2자-4자 아닌 경우")
    @ValueSource(strings = { "안", "안녕안녕안" })
    @ParameterizedTest
    public void coachNameExceptionTest1(String input) {
        assertThatThrownBy(() -> new Coach(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치 이름 예외 테스트 - 이름에 한글이 아닌게 들어갔을 경우")
    @ValueSource(strings = { "안3", "hell" })
    @ParameterizedTest
    public void coachNameExceptionTest2(String input) {
        assertThatThrownBy(() -> new Coach(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치 이름 저장 테스트")
    @ValueSource(strings = { "조은찬" })
    @ParameterizedTest
    public void coachNameTest(String input) {
        assertThat(new Coach(input).getName()).isEqualTo("조은찬");
    }
}
