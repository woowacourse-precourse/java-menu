package menu.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {
    @Test
    @DisplayName("코치 이름 검증")
    public void validateName() {
        assertThatIllegalArgumentException().isThrownBy(()-> {
            new Coach("안녕하세요");
        }).withMessageStartingWith("코치의 이름이 올바르지 않습니다.");

    }
}