package menu.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {
    @Test
    @DisplayName("코치 이름 검증")
    public void validateName() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Coach("안녕하세요");
        }).withMessageStartingWith("코치의 이름이 올바르지 않습니다.");

    }

    @Test
    @DisplayName("이미 등록된 메뉴를 다시 등록할 경우 예외처리한다.")
    public void throwExceptionForDuplicateMenu() {
        Coach hi = new Coach("포비");
        hi.addMenuCannotEat("안뇽");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            hi.addMenuCannotEat("안뇽");
        }).withMessageStartingWith("해당 코치가 못 먹는 메뉴로 이미 등록돼있습니다.");

    }
}