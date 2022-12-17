package menu.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @Test
    void validateCoachNames_int() {
        String coachNames = "이름1, 이름2, 이름3";
        String command = ",";
        assertThatThrownBy(() -> Validator.validateCoachNames(coachNames, command)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validateCoachNames_overLength() {
        String coachNames = "이름입니아, 이름입다, 이름니다";
        String command = ",";
        assertThatThrownBy(() -> Validator.validateCoachNames(coachNames, command)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCoachNames_zero() {
        String coachNames = ", , ";
        String command = ",";
        assertThatThrownBy(() -> Validator.validateCoachNames(coachNames, command)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCoachNames_duplicate() {
        String coachNames = "포비,포비 ,포비 ";
        String command = ",";
        assertThatThrownBy(() -> Validator.validateCoachNames(coachNames, command)).isInstanceOf(IllegalArgumentException.class);
    }
}