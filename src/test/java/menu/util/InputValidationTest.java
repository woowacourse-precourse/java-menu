package menu.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static menu.constant.ExceptionMessage.*;
import static menu.domain.DomainCondition.*;
import static menu.domain.DomainCondition.NAX_COACH_NAME_LENGTH;

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

    @DisplayName("입력받은 코치의 이름이 2~4글자가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"우, 우아", "우테코짱짱, 짱이다"} )
    void 코치_이름_검증_테스트(String userInput) throws Exception {
        InputValidation inputValidation = new InputValidation();

        Assertions.assertThatThrownBy(() ->
                        inputValidation.validateCoach(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(WRONG_COACH_NAME_LENGTH.getValue(), MIN_COACH_NAME_LENGTH.getValue(), NAX_COACH_NAME_LENGTH.getValue()));
    }

    @DisplayName("입력받은 코치가 못 먹는 음식의 개수가 0~2개 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"우동, 스시, 라자냐"} )
    void 코치_음식_검증_테스트(String userInput) throws Exception {
        InputValidation inputValidation = new InputValidation();

        Assertions.assertThatThrownBy(() ->
                        inputValidation.validateNotEatFood(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(WRONG_COACH_FOOD_COUNT.getValue(), MIN_FOOD_COUNT.getValue(), MAX_FOOD_COUNT.getValue()));
    }

}