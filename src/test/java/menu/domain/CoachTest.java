package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @DisplayName("이름이 같으면 동일한 코치이다.")
    @Test
    void duplicateCoach() {
        Coach coach1 = new Coach("홍길동");
        Coach coach2 = new Coach("홍길동");

        assertThat(coach1).isEqualTo(coach2);
    }

    @DisplayName("공백 제거 후 이름이 2글자보다 작으면 예외가 발생한다.")
    @ValueSource(strings = {"", "배", "     "})
    @ParameterizedTest
    void shortLengthName(String name) {
        assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백 제거 후 이름이 4글자보다 크면 예외가 발생한다.")
    @ValueSource(strings = {"가나다라마", "가나다라마바사", "가나다라마바사아자차카"})
    @ParameterizedTest
    void longLengthName(String name) {
        assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백 제거 후 이름이 2글자 이상 4글자 이하면 정상적으로 코치가 생성된다.")
    @ValueSource(strings = {"안녕", "  안녕  ", "홍길동", "자일리톨"})
    @ParameterizedTest
    void validName(String name) {
        Coach coach = new Coach(name);

        assertThat(coach.getName()).isEqualTo(name.trim());
    }
}