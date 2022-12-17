package menu.util;

import menu.service.CoachService;
import menu.util.IllegalArgumentExceptionMessage;
import menu.util.Validate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class ValidateTest {
    @DisplayName("코치의 이름이 기준 이하인 경우, 예외가 발생한다.")
    @Test
    void outOfRangeCoachNameLengthMin() {
        assertThatThrownBy(() -> Validate.validateCoachNames(List.of("톰", "하디")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionMessage.INPUT_COACH_NAME_LENGTH_MIN.getMessage());
    }

    @DisplayName("코치의 이름이 기준 이상인 경우, 예외가 발생한다.")
    @Test
    void outOfRangeCoachNameLengthMax() {
        assertThatThrownBy(() -> Validate.validateCoachNames(List.of("토미제임스", "하디")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionMessage.INPUT_COACH_NAME_LENGTH_MAX.getMessage());
    }

    @DisplayName("코치의 수가 기준 이하인 경우, 예외가 발생한다.")
    @Test
    void outOfRangeNumberOfCoachMin() {
        assertThatThrownBy(() -> Validate.validateCoachNames(List.of("토미")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionMessage.INPUT_COACH_LENGTH_MIN.getMessage());
    }

    @DisplayName("코치의 이름이 5글자 이상인 경우, 예외가 발생한다.")
    @Test
    void outOfRangeNumberOfCoachMax() {
        assertThatThrownBy(() -> Validate.validateCoachNames(List.of("토미", "제임스", "김지섭", "톰하디", "포코", "기타")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionMessage.INPUT_COACH_LENGTH_MAX.getMessage());
    }

    @DisplayName("싫어하는 메뉴의 수가 기준 이상인 경우, 예외가 발생한다.")
    @Test
    void outOfRangeHateMenu() {
        assertThatThrownBy(() -> Validate.validateHateMenu(List.of("규동", "우동", "미소시루")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionMessage.HATE_MENU_SIZE.getMessage());
    }
}
