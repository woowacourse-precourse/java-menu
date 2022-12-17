package menu.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void 입력된_코치인원수가_5보다클때_예외발생() {
        // given
        String coaches = "1, 2, 3, 4, 5, 6";

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.parseCoach( coaches));
    }

    @Test
    void 입력된_코치인원수가_2보다작을때_예외발생() {
        // given
        String coaches = "1";

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.parseCoach( coaches));
    }

    @Test
    void 코치의이름이_2글자보다작을때_예외발생() {
        // given
        String coaches = "1, 123, 124";

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.parseCoach( coaches));
    }

    @Test
    void 메뉴가2개보다클때_예외발생() {
        // given
        String menus = "1, 123, 124";

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputValidator.parseMenu( menus));
    }
}
