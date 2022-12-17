package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputTest {

    @Test
    @DisplayName("코치 이름 유효성")
    void name() {
        assertThatThrownBy(() -> Input.validateCoach("11,2,333"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("없는 메뉴 입력 유효성 검증")
    void menu() {
        assertThatThrownBy(() -> Input.validateHate("자장면"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
