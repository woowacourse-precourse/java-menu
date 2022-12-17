package menu.ui;

import menu.domain.Category;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewValidationTest {

    private static InputViewValidation inputViewValidation = new InputViewValidation();
    @Test
    void coachNumLowInRange() {
        assertThatThrownBy(() -> inputViewValidation.coachNumValidate("정우"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void coachNumOverInRange() {
        assertThatThrownBy(() -> inputViewValidation.coachNumValidate("정우,포비,제이슨,안녕,하세요,반가워"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void coachNameOverInRange() {
        assertThatThrownBy(() -> inputViewValidation.coachNameValidate("정우입니다"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void coachNameLowInRange() {
        assertThatThrownBy(() -> inputViewValidation.coachNameValidate("정"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void coachCannotEatOverInRange() {
        assertThatThrownBy(() -> inputViewValidation.coachCannotEatFoodValidate("떡볶이,짜장면,치킨"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void coachCannotEatFoodValidate() {
        assertThatThrownBy(() -> inputViewValidation.coachCannotEatFoodValidate("밀키트"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}