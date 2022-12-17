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

    @Test
    @DisplayName("코치는 2명 이상 5명이하만 가능합니다.")
    void testIsLimit_success() throws Exception {
        //given
        int input = 4;

        //when & then
        InputValidator.isLimit(input);
    }

    @Test
    @DisplayName("코치가 2명 미만일 경우 IllegalArgumentException을 반환합니다.")
    void testIsLimit_fail() throws Exception {
        //given
        int smallInput = 1;
        int bigInput = 6;

        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> InputValidator.isLimit(smallInput));

        assertThrows(IllegalArgumentException.class,
                     () -> InputValidator.isLimit(bigInput));
    }

}