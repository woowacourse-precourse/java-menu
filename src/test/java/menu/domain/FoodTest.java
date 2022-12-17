package menu.domain;

import menu.utils.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FoodTest {
    @Test
    void from_메소드에_일치하는_음식이_없으면_예외() {
        Assertions.assertThatThrownBy(() -> Food.from("까르보나라불닭"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.FOOD_NOT_EXIST.getMessage());
    }
}