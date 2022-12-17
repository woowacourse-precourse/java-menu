package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("코치 이름은 최소 2글자, 최대 4글자여야 한다.")
    @Test
    void validateNameSize() {
        String[] coaches = {"토미","제임스","포코","포비","크롱뽀로로","미성"};
        assertThatThrownBy(() -> validation.validateNameSize(coaches))
                .isInstanceOf(IllegalArgumentException.class);
        coaches[0] = "토";
        coaches[4] = "크롱";
        assertThatThrownBy(() -> validation.validateNameSize(coaches))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("못먹는 메뉴는 최대 2가지 이다.")
    @Test
    void validateNumberOfHateMenu() {
        String[] hateMenu = {"우동","규동","스파게티"};
        assertThatThrownBy(() -> validation.validateNumberOfHateMenu(hateMenu))
                .isInstanceOf(IllegalArgumentException.class);
    }
}