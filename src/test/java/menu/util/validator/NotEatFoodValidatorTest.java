package menu.util.validator;

import menu.util.constants.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NotEatFoodValidatorTest {

    @Test
    void 못먹는음식_이름_공백_검증() {
        String notEatFoodName = ",짜장면";

        Assertions.assertThatCode(() -> NotEatFoodValidator.validateNotEatFoods(notEatFoodName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_EAT_FOOD_NOT_EMPTY);
    }

    @Test
    void 못먹는음식_이름_중복_검증() {
        String notEatFoodName = "짜장면,짜장면";

        Assertions.assertThatCode(() -> NotEatFoodValidator.validateNotEatFoods(notEatFoodName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_EAT_FOOD_DUPLICATE);
    }

    @Test
    void 못먹는음식_이름_개수_검증() {
        String notEatFoodName = "짜장면,탕수육,김치찌개";

        Assertions.assertThatCode(() -> NotEatFoodValidator.validateNotEatFoods(notEatFoodName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_EAT_FOOD_NUMBER);
    }

}