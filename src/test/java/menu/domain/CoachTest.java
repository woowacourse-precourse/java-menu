package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {

    @Test
    @DisplayName("이름 최소 2자, 최대 4자가 아닐 때 예외")
    void validateLength() {

        assertThatThrownBy(() -> new Coach("a")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Coach("aaaaa")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 제대로 입력 시 생성확인")
    void createCoach() {

        Coach actual = new Coach("우가");
        assertThat(actual).isEqualTo(new Coach("우가"));
    }
}
