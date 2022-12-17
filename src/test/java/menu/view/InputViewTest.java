package menu.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class InputViewTest {
    private static final InputView inputView = new InputView();

    @ParameterizedTest
    @ValueSource(strings = {"김", "오스트랄로피테쿠스", "배달의민족", "우아한형제들"})
    @DisplayName("글자수가 2에서 4사이가 아닌 코치 이름 입력에 대한 예외 처리")
    void readCoachNameLength(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.readCoachName())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"김복남"})
    @DisplayName("코치수가 1에서 5사이가 아닌 코치 이름 입력에 대한 예외 처리")
    void readCoachNameNumber(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.readCoachName())
                .isInstanceOf(IllegalArgumentException.class);
    }
    
}