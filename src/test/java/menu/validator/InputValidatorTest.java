package menu.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("코치 이름의 길이는 2이상 4이하여야한다.")
    void testIsCorrectLength_success() throws Exception {
        //given
        String input = "고기";

        //when
        InputValidator.isCorrectLength(input);
    }

    @Test
    @DisplayName("코치 이름의 길이가 2 미만일 경우 IllegalArgumentException을 반환한다.")
    void testIsCorrectLength_LessThanTwo_fail() throws Exception {
        //given
        String shortInput = "부";

        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> InputValidator.isCorrectLength(shortInput));
    }

    @Test
    @DisplayName("코치 이름의 길이가 4 초과일 경우 IllegalArgumentException을 반환한다.")
    void testIsCorrectLength_MoreThanFour_fail() throws Exception {
        //given
        String longInput = "글자 넘어가기";

        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> InputValidator.isCorrectLength(longInput));
    }

}