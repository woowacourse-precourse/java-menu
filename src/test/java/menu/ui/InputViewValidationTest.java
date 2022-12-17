package menu.ui;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewValidationTest {

    private static InputViewValidation inputViewValidation = new InputViewValidation();
    @Test
    void couchNumLowInRange() {
        assertThatThrownBy(() -> inputViewValidation.couchNumValidate("정우"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void couchNumOverInRange() {
        assertThatThrownBy(() -> inputViewValidation.couchNumValidate("정우,포비,제이슨,안녕,하세요,반가워"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void couchNameOverInRange() {
        assertThatThrownBy(() -> inputViewValidation.couchNumValidate("정우입니다"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void couchNameLowInRange() {
        assertThatThrownBy(() -> inputViewValidation.couchNumValidate("정"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void couchCannotEatNumValidate() {
    }

    @Test
    void couchCannotEatFoodValidate() {
    }
}