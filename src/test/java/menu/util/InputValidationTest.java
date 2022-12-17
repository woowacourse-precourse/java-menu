package menu.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static menu.constant.ExceptionMessage.WRONG_COACH_COUNT;
import static menu.domain.DomainCondition.MAX_COACH_COUNT;
import static menu.domain.DomainCondition.MIN_COACH_COUNT;

class InputValidationTest {

    @DisplayName("입력받은 코치의 수가 2~5명 이내의 값이 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"포비", "포비, 아아, 우테코, 최종, 끝이다, 대박"} )
    void 코치_수_검증_테스트(String userInput) throws Exception {
        InputValidation inputValidation = new InputValidation();

        Assertions.assertThatThrownBy(() ->
                inputValidation.validateCoach(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_COACH_COUNT.getValue(), MIN_COACH_COUNT.getValue(), MAX_COACH_COUNT.getValue());
    }

}