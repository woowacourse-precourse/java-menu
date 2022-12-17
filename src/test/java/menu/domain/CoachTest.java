package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;


class CoachTest {

    @DisplayName("코치 이름이 2자 이하, 4자 이상인 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"민", "김이박최신"})
    void createWrongNameSize(String name) {
        assertThatThrownBy(() -> new Coach(name, new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}