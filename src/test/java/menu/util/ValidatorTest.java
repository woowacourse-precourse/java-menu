package menu.util;

import static org.junit.jupiter.api.Assertions.*;

import menu.message.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("2명 미만의 코치 입력시 예외 발생")
    void 최소_코치_수보다_적은_수의_코치_입력() {
        String input = "제이크";
        try {
            Validator.validateCoachNamesInput(input);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ErrorMessage.LESS_THAN_MINIMUM_NUMBER_OF_COACH, e.getMessage());
        }
    }

    @Test
    @DisplayName("5명 초과의 코치 입력시 예외 발생")
    void 최대_코치_수보다_많은_수의_코치_입력() {
        String input = "제이크,잭,빈,재민,톰,홀란드";
        try {
            Validator.validateCoachNamesInput(input);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ErrorMessage.OVER_MAXIMUM_NUMBER_OF_COACH, e.getMessage());
        }
    }

    @Test
    @DisplayName("같은 코치 두 번 이상 입력시 예외 발생")
    void 중복되는_값_입력() {
        String input = "제이크,제이크,잭";
        try {
            Validator.validateCoachNamesInput(input);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ErrorMessage.SAME_WORD_ENTERED_TWICE, e.getMessage());
        }
    }
}