package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoachTest {
    
    @Test
    @DisplayName("이름 길이 테스트")
    void 예외_테스트1() {
        assertThatThrownBy(() -> new Coach("맘"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 길이 테스트")
    void 예외_테스트2() {
        assertThatThrownBy(() -> new Coach("가나다라마바사아자차카"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
