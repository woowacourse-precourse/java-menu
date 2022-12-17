package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    Validation validation = new Validation();

    @DisplayName("코치는 최소 2명이여야 한다.")
    @Test
    void validateNumberOfCoachesMinimum() {
        String[] coaches = {"미성"};
        assertThatThrownBy(() -> validation.validateNumberOfCoaches(coaches))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치는 최대 5명이여야 한다.")
    @Test
    void validateNumberOfCoachesMaximum() {
        String[] coaches = {"토미","제임스","포코","포비","크롱","미성"};
        assertThatThrownBy(() -> validation.validateNumberOfCoaches(coaches))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNameSize() {
    }

    @Test
    void validateNumberOfHateMenu() {
    }
}