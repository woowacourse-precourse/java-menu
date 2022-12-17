package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    @DisplayName("싫어하는 메뉴 입력 유효성 검증")
    void menu() {
        Assertions.assertThatThrownBy(() -> Input.validateHate("자장면"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
